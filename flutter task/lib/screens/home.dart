import 'package:flutter/material.dart';
import 'package:firebase_appvv/localization/app_localizations.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'booking_page.dart';
import 'history_page.dart';
import 'profile_page.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  Locale _selectedLocale = Locale('en', 'US');

  void _changeLanguage(Locale locale) {
    setState(() {
      _selectedLocale = locale;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      locale: _selectedLocale,
      localizationsDelegates: [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      supportedLocales: [
        Locale('en', 'US'),
        Locale('es', 'ES'),
        Locale('hi', 'IN'),
      ],
      home: Scaffold(
        appBar: AppBar(
          title: Text(AppLocalizations.of(context).translate("title")),
          actions: [
            PopupMenuButton<Locale>(
  onSelected: _changeLanguage,
  itemBuilder: (BuildContext context) => [
    PopupMenuItem(value: Locale('en', 'US'), child: Text('English')),
    PopupMenuItem(value: Locale('es', 'ES'), child: Text('Español')),
    PopupMenuItem(value: Locale('hi', 'IN'), child: Text('हिन्दी')),
    PopupMenuItem(value: Locale('ta', 'IN'), child: Text('தமிழ்')),
  ],
),
          ],
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(AppLocalizations.of(context).translate("select_language")),
            ],
          ),
        ),
      ),
    );
  }
}
