# Library Management System

A comprehensive Java-based Library Management System that demonstrates object-oriented programming concepts and provides a complete solution for managing books, users, and book transactions in a library environment.

## 🎯 Features

- **Book Management**: Add and track books with ID, title, author, and availability status
- **User Management**: Register and manage library users
- **Book Issuing**: Issue books to registered users with validation
- **Book Returning**: Process book returns with proper validation
- **Inventory Tracking**: Real-time display of all books and their status
- **User History**: Track which books each user has borrowed
- **Error Handling**: Comprehensive validation for all operations

## 🏗️ Architecture

This project follows **Object-Oriented Programming** principles with four main classes:

### 1. **Book.java** - Book Model
- Represents a single book in the library
- Contains: ID, Title, Author, Issued Status
- Provides getters, setters, and formatted display
- Tracks whether the book is currently issued

### 2. **User.java** - User Model
- Represents a library user/patron
- Contains: User ID, Name, List of Borrowed Books
- Manages book borrowing and returning operations
- Tracks user's borrowing history

### 3. **Library.java** - Core Management System
- Central controller for all library operations
- Manages collections of books and users
- Provides methods for:
  - `addBook()` - Add new books to library
  - `addUser()` - Register new users
  - `issueBook()` - Issue books to users
  - `returnBook()` - Process book returns
  - `displayBooks()` - Show all books and status
  - `displayUsers()` - Show all users and their borrowed books

### 4. **JavaLibraryManagementSystem.java** - Main Application
- Entry point of the application
- Demonstrates all system functionality
- Provides example usage scenarios

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
```bash
cd Task3
javac JavaLibraryManagementSystem.java
```

### Execution
```bash
java Task3.JavaLibraryManagementSystem
```

## 📋 Usage Guide

### System Operations

1. **Adding Books**
   ```java
   myLibrary.addBook(new Book(1, "The Hobbit", "J.R.R. Tolkien"));
   ```

2. **Registering Users**
   ```java
   myLibrary.addUser(new User(101, "Alice"));
   ```

3. **Issuing Books**
   ```java
   myLibrary.issueBook(bookId, userId);
   ```

4. **Returning Books**
   ```java
   myLibrary.returnBook(bookId, userId);
   ```

5. **Viewing Inventory**
   ```java
   myLibrary.displayBooks();
   myLibrary.displayUsers();
   ```

### Example Session Output

```
--- Welcome to the Library Management System! ---

--- Library Book Inventory ---
ID: 1, Title: 'The Hobbit', Author: 'J.R.R. Tolkien', Issued: false
ID: 2, Title: '1984', Author: 'George Orwell', Issued: false
ID: 3, Title: 'To Kill a Mockingbird', Author: 'Harper Lee', Issued: false
----------------------------

--- Registered Users ---
UserID: 101, Name: 'Alice', Borrowed Books: 0
UserID: 102, Name: 'Bob', Borrowed Books: 0
------------------------

--- Issuing Books ---
Success: 'The Hobbit' has been issued to Alice.
Success: '1984' has been issued to Bob.
Sorry, the book 'The Hobbit' is already issued.
---------------------

--- Library Book Inventory ---
ID: 1, Title: 'The Hobbit', Author: 'J.R.R. Tolkien', Issued: true
ID: 2, Title: '1984', Author: 'George Orwell', Issued: true
ID: 3, Title: 'To Kill a Mockingbird', Author: 'Harper Lee', Issued: false
----------------------------
```

## 🛠️ Technical Details

### Design Patterns Used
- **Object-Oriented Design**: Clear separation of concerns
- **Model Classes**: Book and User as data models
- **Controller Pattern**: Library class manages operations
- **Encapsulation**: Private fields with public getters/setters

### Data Structures
- **ArrayList**: For storing books and users
- **List<Book>**: For tracking user's borrowed books
- **Boolean**: For book availability status

### Error Handling
- **Null Checks**: Validates book and user existence
- **State Validation**: Ensures books are available before issuing
- **User Validation**: Confirms user has borrowed book before return
- **Clear Error Messages**: Informative feedback for all operations

## 📁 Project Structure

```
Task3/
├── JavaLibraryManagementSystem.java    # Main application with all classes
└── README.md                          # This documentation file
```

## 🔧 Key Features Explained

### Book Issuing Logic
```java
public void issueBook(int bookId, int userId) {
    Book book = findBookById(bookId);
    User user = findUserById(userId);
    
    if (book == null || user == null) {
        System.out.println("Error: Book or User not found.");
        return;
    }
    
    if (book.isIssued()) {
        System.out.println("Sorry, the book is already issued.");
    } else {
        book.setIssued(true);
        user.borrowBook(book);
        System.out.println("Success: Book issued to user.");
    }
}
```

### Book Returning Logic
```java
public void returnBook(int bookId, int userId) {
    Book book = findBookById(bookId);
    User user = findUserById(userId);
    
    if (book.isIssued() && user.getBorrowedBooks().contains(book)) {
        book.setIssued(false);
        user.returnBook(book);
        System.out.println("Success: Book returned.");
    } else {
        System.out.println("Error: Invalid return operation.");
    }
}
```

### User Book Tracking
```java
public void borrowBook(Book book) {
    borrowedBooks.add(book);
}

public void returnBook(Book book) {
    borrowedBooks.remove(book);
}
```

## 🎓 Learning Objectives

This project demonstrates:

- **Object-Oriented Programming**: Classes, encapsulation, inheritance
- **Data Structures**: ArrayList, List operations
- **Error Handling**: Validation and exception management
- **System Design**: Separation of concerns and modularity
- **User Interface**: Console-based interaction
- **Business Logic**: Real-world library management scenarios

## 🔮 Future Enhancements

Potential improvements for this system:

- **Database Integration**: Replace in-memory storage with SQL database
- **File I/O**: Save data to CSV or JSON files
- **GUI Interface**: Create graphical user interface using Swing/JavaFX
- **Advanced Search**: Search books by title, author, or availability
- **Due Date Tracking**: Add due dates and late fee calculations
- **Multiple Copies**: Support for multiple copies of the same book
- **User Authentication**: Add login system with passwords
- **Reporting**: Generate borrowing reports and statistics
- **Email Notifications**: Send reminders for overdue books

## 🧪 Testing Scenarios

The system demonstrates various scenarios:

1. **Successful Book Issuing**: User borrows available book
2. **Failed Book Issuing**: Attempt to borrow already issued book
3. **Successful Book Return**: User returns borrowed book
4. **Failed Book Return**: Attempt to return book not borrowed by user
5. **Invalid Operations**: Using non-existent book or user IDs

## 🤝 Contributing

Feel free to enhance this Library Management System by:

1. Adding new features (due dates, fines, etc.)
2. Improving error handling and validation
3. Implementing database connectivity
4. Creating unit tests
5. Adding more comprehensive documentation
6. Implementing a GUI interface

## 📄 License

This project is part of the Elevate Lab internship program.

---

**Developed with ❤️ using Java** 