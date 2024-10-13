package dsa.examples.tdd;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String id;

    // Constructor
    public Student(String name, int age, String id) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("La edad debe estar entre 18 y 100 años.");
        }
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Student() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    // Sobrescribir equals y hashCode para comparar por id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
