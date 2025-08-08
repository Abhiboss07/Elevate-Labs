package Task4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1. Add a new note");
            System.out.println("2. View all notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNote(scanner);
                    break;
                case "2":
                    viewNotes();
                    break;
                case "3":
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close(); // Close the scanner before exiting
                    return; // Exit the main method, terminating the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Prompts the user for a note and appends it to the file.
     * @param scanner The scanner to read user input.
     */
    private static void addNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        // Use try-with-resources to ensure the writer is closed automatically.
        // new FileWriter(FILE_NAME, true) opens the file in append mode.
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

    /**
     * Reads all notes from the file and displays them.
     */
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---");

        // Use try-with-resources to ensure the reader is closed automatically.
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader reader = new BufferedReader(fr)) {

            String line;
            int noteNumber = 1;
            boolean notesFound = false;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(noteNumber + ". " + line);
                noteNumber++;
                notesFound = true;
            }

            if (!notesFound) {
                System.out.println("No notes found. Add one first!");
            }

        } catch (IOException e) {
            // This often means the file doesn't exist yet, which is fine on first run.
            System.out.println("No notes found. Add one first!");
        }
        System.out.println("--------------------");
    }
}