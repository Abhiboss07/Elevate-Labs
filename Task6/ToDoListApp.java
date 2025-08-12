package Task6;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple To-Do List application built with Java Swing.
 * This class sets up the main window and all the UI components.
 */
public class ToDoListApp extends JFrame {

    // --- GUI Components ---
    // The model holds the data (the to-do items). The JList displays it.
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addButton;
    private JButton deleteButton;
    private JPanel mainPanel;

    /**
     * Constructor to set up the application's GUI.
     */
    public ToDoListApp() {
        // 1. --- Set up the main window (JFrame) ---
        setTitle("My To-Do List");
        setSize(450, 350); // Set a default size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the app when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen

        // 2. --- Create and configure the main panel ---
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10)); // Use BorderLayout with gaps
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding around the panel
        setContentPane(mainPanel);

        // 3. --- Create the list of tasks ---
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one item to be selected at a time
        taskList.setFont(new Font("Arial", Font.PLAIN, 14)); // Set a nice font
        
        // Add some initial example tasks
        listModel.addElement("Buy groceries");
        listModel.addElement("Finish Java Swing project");
        listModel.addElement("Go for a run");

        // Add the list to a scroll pane to enable scrolling if the list gets long
        JScrollPane scrollPane = new JScrollPane(taskList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 4. --- Create the input panel at the bottom ---
        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        taskInputField = new JTextField("Enter new task here...");
        taskInputField.setFont(new Font("Arial", Font.ITALIC, 12));
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");
        
        // Style the buttons
        addButton.setBackground(new Color(76, 175, 80)); // Green
        addButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(244, 67, 54)); // Red
        deleteButton.setForeground(Color.WHITE);

        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        
        // Create a panel for the buttons to group them
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Add the input field and button panel to the main input panel
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // 5. --- Add Action Listeners to make the buttons work ---
        addListeners();
    }

    /**
     * This method contains the logic for what happens when buttons are clicked.
     */
    private void addListeners() {
        // Add Task Button Action Listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the input field
                String task = taskInputField.getText().trim();

                // Add the task to the list if it's not empty
                if (!task.isEmpty() && !task.equals("Enter new task here...")) {
                    listModel.addElement(task); // Add task to the list model
                    taskInputField.setText(""); // Clear the input field
                } else {
                    // Show a warning message if the input is empty
                    JOptionPane.showMessageDialog(ToDoListApp.this, 
                                                  "Please enter a valid task.", 
                                                  "Warning", 
                                                  JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Delete Task Button Action Listener
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the index of the selected item in the list
                int selectedIndex = taskList.getSelectedIndex();

                // If an item is selected (index is not -1), remove it
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex); // Remove the selected task
                } else {
                    // Show a warning message if no task is selected
                    JOptionPane.showMessageDialog(ToDoListApp.this, 
                                                  "Please select a task to delete.", 
                                                  "Warning", 
                                                  JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Add an action listener to the text field to add task on "Enter" key press
        taskInputField.addActionListener(e -> addButton.doClick());

        // Add a focus listener to clear the placeholder text on click
        taskInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (taskInputField.getText().equals("Enter new task here...")) {
                    taskInputField.setText("");
                    taskInputField.setFont(new Font("Arial", Font.PLAIN, 12));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (taskInputField.getText().isEmpty()) {
                    taskInputField.setText("Enter new task here...");
                    taskInputField.setFont(new Font("Arial", Font.ITALIC, 12));
                }
            }
        });
    }

    /**
     * The main method to run the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT) for thread safety.
        // This is the standard and correct way to start a Swing application.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Set a modern Look and Feel (Nimbus)
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the system look and feel.
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                
                new ToDoListApp().setVisible(true);
            }
        });
    }
}
