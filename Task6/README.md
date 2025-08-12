## To-Do List App (Task 6)

### Overview
A simple, modern To-Do List desktop application built with Java Swing. It demonstrates clean UI layout, basic state management with a `DefaultListModel`, and user-friendly interactions.

### Features
- **Add tasks**: Type a task and press Enter or click "Add Task"
- **Delete tasks**: Select a task and click "Delete Task"
- **Single selection**: Prevents accidental multi-delete
- **Placeholder text**: Input shows a helpful hint until focused
- **Keyboard-friendly**: Press Enter to add
- **Styled UI**: Nimbus Look & Feel (falls back to system L&F)
- **Sample tasks**: Prepopulated example items on startup

### Tech Stack
- **Language**: Java (SE 8+)
- **UI Toolkit**: Swing (`javax.swing`, `java.awt`)

### Project Structure
```
Task6/
├── ToDoListApp.java   // Main application window and logic
└── README.md          // This file
```

### How to Run (Terminal)
From the project root (the folder that contains the `Task6/` directory):

```bash
# Compile
javac Task6/ToDoListApp.java

# Run
java Task6.ToDoListApp
```

On Windows PowerShell, the same commands work when executed from the project root.

### How to Run (IDE)
- Open the project in your IDE (IntelliJ IDEA, VS Code, Eclipse, etc.)
- Ensure the source root contains the `Task6/` folder
- Run the `main` method in `Task6.ToDoListApp`

### Usage Tips
- Click the input field to clear the placeholder
- Press Enter to quickly add a task
- Select a task in the list before clicking "Delete Task"

### Troubleshooting
- **Error: Could not find or load main class Task6.ToDoListApp**
  - Run from the project root (not inside `Task6/`)
  - Ensure the package declaration `package Task6;` matches the folder name
- **UI looks dated**
  - Nimbus may not be available on all JREs; the app falls back to the system Look & Feel automatically

### Notes
- This app stores data in memory only (no persistence). Restarting clears the list.
- Great starting point to add persistence (files/DB), filtering, editing tasks, and due dates.
