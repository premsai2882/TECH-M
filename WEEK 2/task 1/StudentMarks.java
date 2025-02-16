import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.average = (double) this.total / marks.length;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.total, this.total); // Descending order
    }

    @Override
    public String toString() {
        return name + "- Total: " + total + ", Average: " + average;
    }
}

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            int[] marks = new int[subjects];
            System.out.print("Enter marks: ");
            for (int j = 0; j < subjects; j++) {
                marks[j] = sc.nextInt();
            }
            sc.nextLine();
            students[i] = new Student(name, marks);
        }
        Arrays.sort(students);
        System.out.println("\nSorted Student List:");
        for (Student s : students) {
            System.out.println(s);
        }
        sc.close();
    }
}