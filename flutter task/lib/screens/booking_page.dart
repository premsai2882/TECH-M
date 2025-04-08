import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';

class BookingPage extends StatefulWidget {
  @override
  _BookingPageState createState() => _BookingPageState();
}

class _BookingPageState extends State<BookingPage> {
  final TextEditingController _carModelController = TextEditingController();
  String _selectedService = 'Oil Change';
  DateTime _selectedDate = DateTime.now();

  Future<void> _bookService() async {
    User? user = FirebaseAuth.instance.currentUser;
    if (user != null) {
      await FirebaseFirestore.instance.collection('bookings').add({
        'userId': user.uid,
        'carModel': _carModelController.text,
        'serviceType': _selectedService,
        'preferredDate': _selectedDate.toIso8601String(),
        'status': 'Pending',
      });

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Service Booked Successfully!")),
      );

      _carModelController.clear();
    }
  }

  void _selectDate(BuildContext context) async {
    DateTime? picked = await showDatePicker(
      context: context,
      initialDate: _selectedDate,
      firstDate: DateTime.now(),
      lastDate: DateTime(2026),
    );

    if (picked != null) {
      setState(() {
        _selectedDate = picked;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Book a Car Service")),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _carModelController,
              decoration: InputDecoration(labelText: "Car Model"),
            ),
            DropdownButton<String>(
              value: _selectedService,
              onChanged: (String? newValue) {
                setState(() {
                  _selectedService = newValue!;
                });
              },
              items: <String>['Oil Change', 'Brake Repair', 'Battery Replacement', 'General Checkup']
                  .map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            ListTile(
              title: Text("Preferred Date: ${_selectedDate.toLocal()}".split(' ')[0]),
              trailing: Icon(Icons.calendar_today),
              onTap: () => _selectDate(context),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: _bookService,
              child: Text("Book Service"),
            ),
          ],
        ),
      ),
    );
  }
}
