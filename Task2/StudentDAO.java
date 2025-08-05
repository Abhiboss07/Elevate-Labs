import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object (DAO) for Student records.
 * This class handles all the data operations (CRUD) for the students.
 * In this simple example, we are using an in-memory ArrayList as our database.
 */
public class StudentDAO {
    private final List<Student> studentList = new ArrayList<>();
    private int nextId = 1; // Used to auto-generate student IDs.

    /**
     * C - Create: Adds a new student to the list.
     * The ID for the new student is generated automatically.
     *
     * @param student The student object to be added.
     */
    public void addStudent(Student student) {
        student.setId(nextId++);
        studentList.add(student);
    }

    /**
     * R - Read: Retrieves all students from the list.
     *
     * @return A list of all students.
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList); // Return a copy to prevent external modification
    }

    /**
     * R - Read: Retrieves a single student by their ID.
     *
     * @param id The ID of the student to find.
     * @return An Optional containing the student if found, otherwise an empty Optional.
     */
    public Optional<Student> getStudentById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    /**
     * U - Update: Modifies the details of an existing student.
     *
     * @param updatedStudent The student object with updated information.
     * @return true if the student was found and updated, false otherwise.
     */
    public boolean updateStudent(Student updatedStudent) {
        Optional<Student> studentOptional = getStudentById(updatedStudent.getId());
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGrade(updatedStudent.getGrade());
            existingStudent.setEmail(updatedStudent.getEmail());
            return true;
        }
        return false;
    }

    /**
     * D - Delete: Removes a student from the list by their ID.
     *
     * @param id The ID of the student to be deleted.
     * @return true if the student was found and deleted, false otherwise.
     */
    public boolean deleteStudent(int id) {
        return studentList.removeIf(student -> student.getId() == id);
    }
}
