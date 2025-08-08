package Task3;
import java.util.ArrayList;
import java.util.List;

/**
 * Book.java
 * This class represents a single book in the library.
 * It holds information about the book's ID, title, author, and availability.
 */
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    /**
     * Constructor to create a new Book.
     * @param id The unique ID of the book.
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false; // By default, a new book is not issued.
    }

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: '" + title + "', Author: '" + author + "', Issued: " + isIssued;
    }
}

/**
 * User.java
 * This class represents a library user.
 * It holds the user's ID, name, and a list of books they have borrowed.
 */
class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    /**
     * Constructor to create a new User.
     * @param userId The unique ID for the user.
     * @param name The name of the user.
     */
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // --- Getters ---

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    /**
     * Adds a book to the user's borrowed list.
     * @param book The book to be borrowed.
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Removes a book from the user's borrowed list.
     * @param book The book to be returned.
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "UserID: " + userId + ", Name: '" + name + "', Borrowed Books: " + borrowedBooks.size();
    }
}

/**
 * Library.java
 * This class manages the collection of books and registered users.
 * It contains the core logic for issuing and returning books.
 */
class Library {
    private List<Book> books;
    private List<User> users;

    /**
     * Constructor to create a new Library.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    /**
     * Adds a new book to the library's collection.
     * @param book The book to add.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Registers a new user with the library.
     * @param user The user to register.
     */
    public void addUser(User user) {
        users.add(user);
    }
    
    /**
     * Finds a book by its ID.
     * @param bookId The ID of the book to find.
     * @return The Book object if found, otherwise null.
     */
    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    /**
     * Finds a user by their ID.
     * @param userId The ID of the user to find.
     * @return The User object if found, otherwise null.
     */
    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    /**
     * Issues a book to a user.
     * @param bookId The ID of the book to be issued.
     * @param userId The ID of the user borrowing the book.
     */
    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Error: Book with ID " + bookId + " not found.");
            return;
        }
        if (user == null) {
            System.out.println("Error: User with ID " + userId + " not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is already issued.");
        } else {
            book.setIssued(true);
            user.borrowBook(book);
            System.out.println("Success: '" + book.getTitle() + "' has been issued to " + user.getName() + ".");
        }
    }

    /**
     * Processes the return of a book from a user.
     * @param bookId The ID of the book being returned.
     * @param userId The ID of the user returning the book.
     */
    public void returnBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null || user == null) {
            System.out.println("Error: Invalid book ID or user ID.");
            return;
        }

        if (book.isIssued() && user.getBorrowedBooks().contains(book)) {
            book.setIssued(false);
            user.returnBook(book);
            System.out.println("Success: '" + book.getTitle() + "' has been returned by " + user.getName() + ".");
        } else {
            System.out.println("Error: This book was not issued to this user or is not currently issued.");
        }
    }

    /**
     * Displays the status of all books in the library.
     */
    public void displayBooks() {
        System.out.println("\n--- Library Book Inventory ---");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("----------------------------\n");
    }
    
    /**
     * Displays the details of all registered users.
     */
    public void displayUsers() {
        System.out.println("\n--- Registered Users ---");
        for (User user : users) {
            System.out.println(user);
            // Optionally display the titles of borrowed books
            if (!user.getBorrowedBooks().isEmpty()) {
                System.out.println("  Borrowed Books:");
                for (Book book : user.getBorrowedBooks()) {
                    System.out.println("    - " + book.getTitle());
                }
            }
        }
        System.out.println("------------------------\n");
    }
}

/**
 * Main.java
 * This is the entry point of the application.
 * It demonstrates the functionality of the library system.
 */
public class JavaLibraryManagementSystem {
    public static void main(String[] args) {
        // 1. Initialize the Library
        Library myLibrary = new Library();

        // 2. Add some books to the library
        myLibrary.addBook(new Book(1, "The Hobbit", "J.R.R. Tolkien"));
        myLibrary.addBook(new Book(2, "1984", "George Orwell"));
        myLibrary.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        // 3. Register some users
        myLibrary.addUser(new User(101, "Alice"));
        myLibrary.addUser(new User(102, "Bob"));

        // 4. Display initial status
        System.out.println("--- Welcome to the Library Management System! ---");
        myLibrary.displayBooks();
        myLibrary.displayUsers();

        // 5. Demonstrate book issuing
        System.out.println("--- Issuing Books ---");
        myLibrary.issueBook(1, 101); // Alice borrows "The Hobbit"
        myLibrary.issueBook(2, 102); // Bob borrows "1984"
        myLibrary.issueBook(1, 102); // Bob tries to borrow "The Hobbit", which is already out
        System.out.println("---------------------\n");
        
        // 6. Display status after issuing
        myLibrary.displayBooks();
        myLibrary.displayUsers();

        // 7. Demonstrate book returning
        System.out.println("--- Returning Books ---");
        myLibrary.returnBook(1, 101); // Alice returns "The Hobbit"
        myLibrary.returnBook(3, 102); // Bob tries to return a book he didn't borrow
        System.out.println("---------------------\n");

        // 8. Display final status
        System.out.println("--- Final Library Status ---");
        myLibrary.displayBooks();
        myLibrary.displayUsers();
    }
}
