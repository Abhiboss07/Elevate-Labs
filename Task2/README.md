# Student Management System

A comprehensive command-line Student Management System implemented in Java using the DAO (Data Access Object) pattern. This application provides a complete CRUD (Create, Read, Update, Delete) interface for managing student records.

## 🎯 Features

- **Add Students**: Create new student records with auto-generated IDs
- **View All Students**: Display all student records in a formatted list
- **Update Students**: Modify existing student information
- **Delete Students**: Remove student records by ID
- **Interactive Menu**: User-friendly command-line interface
- **Input Validation**: Robust error handling and input validation
- **In-Memory Storage**: Uses ArrayList for data persistence during runtime

## 🏗️ Architecture

This project follows the **DAO (Data Access Object)** pattern with three main components:

### 1. **Student.java** - Model Class
- Represents a single student record
- Contains student attributes: ID, Name, Grade, Email
- Provides getters and setters for all fields
- Includes a formatted `toString()` method for display

### 2. **StudentDAO.java** - Data Access Object
- Handles all database operations (CRUD)
- Uses in-memory ArrayList for data storage
- Auto-generates unique IDs for new students
- Provides methods for:
  - `addStudent()` - Create new records
  - `getAllStudents()` - Retrieve all records
  - `getStudentById()` - Find specific student
  - `updateStudent()` - Modify existing records
  - `deleteStudent()` - Remove records

### 3. **Main.java** - User Interface
- Command-line interface for user interaction
- Menu-driven navigation
- Input validation and error handling
- Continuous operation until user chooses to exit

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
```bash
cd Task2
javac *.java
```

### Execution
```bash
java Main
```

## 📋 Usage Guide

### Main Menu Options

1. **Add a new Student**
   - Enter student name
   - Enter grade/course (e.g., "10th", "B.Sc. CS")
   - Enter email address
   - Student ID is auto-generated

2. **View all Students**
   - Displays all student records in formatted list
   - Shows "No student records found" if list is empty

3. **Update a Student's record**
   - Enter the student ID to update
   - For each field, enter new value or leave blank to keep current
   - Shows current values in brackets for reference

4. **Delete a Student**
   - Enter the student ID to delete
   - Confirms successful deletion or "not found" message

5. **Exit**
   - Gracefully terminates the application

### Example Session

```
--- Student Management System ---
1. Add a new Student
2. View all Students
3. Update a Student's record
4. Delete a Student
5. Exit
Enter your choice: 1

--- Add New Student ---
Enter Name: John Doe
Enter Grade (e.g., 10th, B.Sc. CS): B.Sc. Computer Science
Enter Email: john.doe@email.com
Student added successfully!

Press Enter to continue...
```

## 🛠️ Technical Details

### Design Patterns Used
- **DAO Pattern**: Separates data access logic from business logic
- **MVC-like Structure**: Model (Student), Controller (Main), Data Access (StudentDAO)

### Data Structure
- **In-Memory Storage**: ArrayList for student records
- **Auto-ID Generation**: Sequential ID assignment starting from 1
- **Immutable Collections**: Returns copies to prevent external modification

### Error Handling
- **Input Validation**: Checks for valid integer inputs
- **Exception Handling**: Try-catch blocks for robust error management
- **User Feedback**: Clear error messages and confirmations

## 📁 Project Structure

```
Task2/
├── Main.java          # Main application and user interface
├── Student.java       # Student model class
├── StudentDAO.java    # Data access object for CRUD operations
└── README.md         # This documentation file
```

## 🔧 Key Features Explained

### Auto-ID Generation
```java
private int nextId = 1; // Used to auto-generate student IDs
public void addStudent(Student student) {
    student.setId(nextId++);
    studentList.add(student);
}
```

### Input Validation
```java
private static int getUserChoice() {
    while (!scanner.hasNextInt()) {
        System.out.print("Invalid input. Please enter a number: ");
        scanner.next(); // discard non-integer input
    }
    int choice = scanner.nextInt();
    scanner.nextLine(); // consume newline left-over
    return choice;
}
```

### Optional Pattern for Safe Retrieval
```java
public Optional<Student> getStudentById(int id) {
    return studentList.stream()
            .filter(student -> student.getId() == id)
            .findFirst();
}
```

## 🎓 Learning Objectives

This project demonstrates:

- **Object-Oriented Programming**: Classes, encapsulation, inheritance
- **Design Patterns**: DAO pattern implementation
- **Collections Framework**: ArrayList, Stream API
- **Exception Handling**: Try-catch blocks and input validation
- **User Interface Design**: Command-line interface best practices
- **Data Management**: CRUD operations and data persistence

## 🔮 Future Enhancements

Potential improvements for this system:

- **Database Integration**: Replace in-memory storage with SQL database
- **File I/O**: Save data to CSV or JSON files
- **GUI Interface**: Create graphical user interface using Swing/JavaFX
- **Advanced Search**: Search by name, email, or grade
- **Data Validation**: Email format validation, grade validation
- **Reporting**: Generate student reports and statistics
- **User Authentication**: Add login system for multiple users

## 🤝 Contributing

Feel free to enhance this Student Management System by:

1. Adding new features
2. Improving error handling
3. Implementing database connectivity
4. Creating unit tests
5. Adding documentation

## 📄 License

This project is part of the Elevate Lab internship program.

---

**Developed with ❤️ using Java** 