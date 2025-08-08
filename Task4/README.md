# Notes Manager

A simple yet powerful command-line Notes Manager application built in Java that allows users to create, save, and view personal notes with persistent file storage.

## 🎯 Features

- **Add Notes**: Create and save new notes with persistent storage
- **View Notes**: Display all previously saved notes with numbering
- **File Persistence**: Notes are automatically saved to `notes.txt`
- **User-Friendly Interface**: Simple menu-driven console application
- **Error Handling**: Robust file I/O operations with proper exception handling
- **Cross-Platform**: Works on Windows, macOS, and Linux

## 🏗️ Architecture

This project follows **Object-Oriented Programming** principles with a single main class:

### **NotesManager.java** - Main Application
- Entry point of the application
- Handles user interaction through console menu
- Manages file I/O operations for note persistence
- Implements proper resource management with try-with-resources

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
```bash
cd Task4
javac NotesManager.java
```

### Execution
```bash
# From the parent directory (Elevate Lab)
java Task4.NotesManager

# Or from within Task4 directory
cd Task4
java -cp .. Task4.NotesManager
```

## 📋 Usage Guide

### Main Menu Options

1. **Add a new note**
   - Enter your note text when prompted
   - Note is automatically saved to `notes.txt`
   - Confirmation message is displayed

2. **View all notes**
   - Displays all saved notes with numbering
   - Shows "No notes found" if file is empty or doesn't exist
   - Notes are displayed in order of creation

3. **Exit**
   - Gracefully terminates the application
   - All resources are properly closed

### Example Session

```
--- Notes Manager ---
1. Add a new note
2. View all notes
3. Exit
Choose an option: 1

Enter your note: Remember to buy groceries tomorrow
Note added successfully!

--- Notes Manager ---
1. Add a new note
2. View all notes
3. Exit
Choose an option: 2

--- Your Notes ---
1. Remember to buy groceries tomorrow
--------------------

--- Notes Manager ---
1. Add a new note
2. View all notes
3. Exit
Choose an option: 3
Exiting the program. Goodbye!
```

## 🛠️ Technical Details

### Design Patterns Used
- **Single Responsibility**: Each method has a specific purpose
- **Resource Management**: Try-with-resources for automatic cleanup
- **Error Handling**: Comprehensive exception handling for file operations

### File Operations
- **FileWriter**: Writes notes to `notes.txt` in append mode
- **BufferedReader**: Reads notes from file for display
- **Persistent Storage**: Notes survive program restarts
- **Append Mode**: New notes don't overwrite existing ones

### Data Flow
1. **Input**: User enters note text via Scanner
2. **Storage**: Note is written to `notes.txt` with newline
3. **Retrieval**: File is read line-by-line for display
4. **Output**: Notes are numbered and displayed to user

## 📁 Project Structure

```
Task4/
├── NotesManager.java    # Main application with all functionality
├── README.md           # This documentation file
└── notes.txt           # Generated file containing saved notes
```

## 🔧 Key Features Explained

### Note Addition Logic
```java
private static void addNote(Scanner scanner) {
    System.out.print("Enter your note: ");
    String note = scanner.nextLine();

    try (FileWriter fw = new FileWriter(FILE_NAME, true);
         BufferedWriter writer = new BufferedWriter(fw)) {
        
        writer.write(note);
        writer.newLine(); // Adds a new line for the next note
        System.out.println("Note added successfully!");

    } catch (IOException e) {
        System.err.println("An error occurred while writing to the file.");
        e.printStackTrace();
    }
}
```

### Note Viewing Logic
```java
private static void viewNotes() {
    System.out.println("\n--- Your Notes ---");

    try (FileReader fr = new FileReader(FILE_NAME);
         BufferedReader reader = new BufferedReader(fr)) {

        String line;
        int noteNumber = 1;
        boolean notesFound = false;

        while ((line = reader.readLine()) != null) {
            System.out.println(noteNumber + ". " + line);
            noteNumber++;
            notesFound = true;
        }

        if (!notesFound) {
            System.out.println("No notes found. Add one first!");
        }

    } catch (IOException e) {
        System.out.println("No notes found. Add one first!");
    }
}
```

### Resource Management
```java
// Try-with-resources ensures automatic cleanup
try (FileWriter fw = new FileWriter(FILE_NAME, true);
     BufferedWriter writer = new BufferedWriter(fw)) {
    // File operations here
} catch (IOException e) {
    // Error handling
}
```

## 🎓 Learning Objectives

This project demonstrates:

- **File I/O Operations**: Reading and writing to text files
- **Exception Handling**: Proper error management for file operations
- **Resource Management**: Automatic cleanup with try-with-resources
- **User Interface Design**: Console-based menu system
- **Data Persistence**: Saving data between program sessions
- **Input Validation**: Handling user input safely
- **Cross-Platform Development**: Java's portability

## 🔮 Future Enhancements

Potential improvements for this Notes Manager:

- **Note Categories**: Organize notes by categories/tags
- **Search Functionality**: Search through notes by keywords
- **Note Editing**: Modify existing notes
- **Note Deletion**: Remove unwanted notes
- **Date/Time Stamps**: Add timestamps to notes
- **Rich Text Support**: Support for formatting and special characters
- **GUI Interface**: Create graphical user interface using Swing/JavaFX
- **Database Integration**: Store notes in SQL database
- **Cloud Sync**: Synchronize notes across devices
- **Export Options**: Export notes to different formats (PDF, TXT, etc.)
- **Encryption**: Secure notes with password protection
- **Backup System**: Automatic backup of notes file

## 🧪 Testing Scenarios

The system handles various scenarios:

1. **First Run**: No existing notes file
2. **Adding Notes**: Successfully writing to file
3. **Viewing Empty File**: Graceful handling of no notes
4. **File I/O Errors**: Proper exception handling
5. **Invalid Input**: Menu option validation
6. **Program Exit**: Clean resource cleanup

## 🤝 Contributing

Feel free to enhance this Notes Manager by:

1. Adding new features (categories, search, etc.)
2. Improving error handling and validation
3. Implementing database connectivity
4. Creating unit tests
5. Adding more comprehensive documentation
6. Implementing a GUI interface
7. Adding note encryption features

## 📄 License

This project is part of the Elevate Lab internship program.

---

**Developed with ❤️ using Java** 