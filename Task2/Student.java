/**
 * Represents a single student record.
 * This class acts as the model in our application.
 */
public class Student {
    private int id;
    private String name;
    private String grade;
    private String email;

    /**
     * Constructs a new Student object.
     *
     * @param id    The student's unique ID.
     * @param name  The student's name.
     * @param grade The student's grade or course.
     * @param email The student's email address.
     */
    public Student(int id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    // Getters and Setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the Student object.
     * This is useful for displaying the student's details.
     *
     * @return A formatted string with the student's information.
     */
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Grade=" + grade + ", Email=" + email + "]";
    }
}
