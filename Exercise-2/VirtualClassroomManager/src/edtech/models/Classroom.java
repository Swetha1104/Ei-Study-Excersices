package edtech.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Represents a virtual classroom that holds students and assignments.
 */
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final Map<String, Student> students;
    private final List<String> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Collection<Student> getStudents() {
        return students.values();
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void addStudent(Student student) {
        if (students.containsKey(student.getStudentId())) {
            System.out.println("Student " + student.getStudentId() + " is already enrolled in " + name + ".");
            return;
        }
        students.put(student.getStudentId(), student);
        System.out.println("Student " + student.getStudentId() + " has been enrolled in " + name + ".");
    }

    public void scheduleAssignment(String assignment) {
        assignments.add(assignment);
        System.out.println("Assignment for " + name + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String assignment) {
        Student student = students.get(studentId);
        if (student != null) {
            student.submitAssignment(name, assignment);
        } else {
            System.out.println("Student " + studentId + " is not enrolled in " + name + ".");
        }
    }

    public void markAttendance(String studentId, LocalDate date, boolean present) {
        Student student = students.get(studentId);
        if (student != null) {
            student.markAttendance(name, date, present);
        } else {
            System.out.println("Student " + studentId + " is not enrolled in " + name + ".");
        }
    }

    public void viewAttendance(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            student.viewAttendance(name);
        } else {
            System.out.println("Student " + studentId + " is not enrolled in " + name + ".");
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + name + ".");
            return;
        }
        System.out.println("Students in " + name + ":");
        students.keySet().forEach(System.out::println);
    }
}
