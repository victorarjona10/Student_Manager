package dsa.examples.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class StudentTest {

    /**
     * Rigorous Test :-)
     */

    @Test
    public void testAddStudent() {
        StudentManager manager = new StudentManager();
        Student student = new Student("Alice", 20, "123");

        manager.addStudent(student);
        assertTrue(manager.getAllStudents().contains(student));
    }

    @Test
    public void testRemoveStudent() {
        StudentManager manager = new StudentManager();
        Student student = new Student("Bob", 25, "456");

        manager.addStudent(student);
        manager.removeStudentById("456");
        assertFalse(manager.getAllStudents().contains(student));
    }

    @Test
    public void testFindStudentById() {
        StudentManager manager = new StudentManager();
        Student student = new Student("Charlie", 22, "789");

        manager.addStudent(student);
        assertNotNull(manager.findStudentById("789"));
        assertNull(manager.findStudentById("999"));
    }

    @Test
    public void testAddDuplicateStudent() {
        StudentManager manager = new StudentManager();
        Student student1 = new Student("Alice", 20, "123");
        Student student2 = new Student("Alice", 21, "123");

        manager.addStudent(student1);
        assertThrows(IllegalArgumentException.class, () -> manager.addStudent(student2));
    }

    @Test
    public void testGetAllStudents() {
        StudentManager manager = new StudentManager();
        Student student1 = new Student("Alice", 20, "123");
        Student student2 = new Student("Bob", 25, "456");

        manager.addStudent(student1);
        manager.addStudent(student2);

        List<Student> expectedStudents = List.of(student1, student2);
        assertIterableEquals(expectedStudents, manager.getAllStudents());
    }

    @Test
    public void testStudentEquality() {
        Student student1 = new Student("Alice", 20, "123");
        Student student2 = new Student("Alice", 21, "123");
        Student student3 = new Student("Bob", 22, "456");

        assertEquals(student1, student2); // Mismo ID
        assertNotEquals(student1, student3); // Diferente ID
    }
}
