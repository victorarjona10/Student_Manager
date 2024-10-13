package dsa.examples.tdd;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class StudentManager extends Student{
    public StudentManager(String name, int age, String id) {
        super(name, age, id);
    }
    //public static void main(String[] args) {
       // System.out.println("Hello World!");


    private List<Student> students;

    // Constructor
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Método para agregar estudiante
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("No se puede agregar un estudiante nulo.");
        }
        // Verificar si ya existe un estudiante con el mismo id
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            throw new IllegalArgumentException("Ya existe un estudiante con el mismo ID.");
        }
        students.add(student);
    }

    // Método para eliminar estudiante por id
    public void removeStudentById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        students.removeIf(s -> s.getId().equals(id));
    }

    // Método para buscar estudiante por id
    public Student findStudentById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    // Método para obtener todos los estudiantes
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }






//    public static int add(int a, int b)
//    {
//        return a + b;
//
//    }
//    public static int substract (int a, int b)
//    {
//        return a - b;
//    }
//    public static int multiply(int a, int b)
//    {
//        return a*b;
//    }
//    public static float divide(int a , int b)
//    {
//        if (b == 0)
//        {
//            throw new IllegalArgumentException("division entre 0 no permitida");
//        }
//        else
//        {
//            return a/b;
//        }
//
//    }

}
