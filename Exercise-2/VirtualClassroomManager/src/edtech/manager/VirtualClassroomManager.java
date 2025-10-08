package edtech.manager;

import edtech.models.Classroom;
import edtech.models.Student;
import edtech.persistence.PersistenceManager;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Singleton manager for all classroom operations.
 */
public class VirtualClassroomManager {
    private static volatile VirtualClassroomManager instance;
    private Map<String, Classroom> classrooms;

    private VirtualClassroomManager() {
        this.classrooms = new ConcurrentHashMap<>(PersistenceManager.loadData());
    }

    public static VirtualClassroomManager getInstance() {
        if (instance == null) {
            synchronized (VirtualClassroomManager.class) {
                if (instance == null) {
                    instance = new VirtualClassroomManager();
                }
            }
        }
        return instance;
    }

    private void save() {
        PersistenceManager.saveData(classrooms);
    }

    public void addClassroom(String className) {
        classrooms.putIfAbsent(className, new Classroom(className));
        save();
        System.out.println("Classroom " + className + " has been created.");
    }

    public void removeClassroom(String className) {
        if (classrooms.remove(className) != null) {
            save();
            System.out.println("Classroom " + className + " removed.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(new Student(studentId));
            save();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignment) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.scheduleAssignment(assignment);
            save();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignment) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.submitAssignment(studentId, assignment);
            save();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void markAttendance(String studentId, String className, LocalDate date, boolean present) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.markAttendance(studentId, date, present);
            save();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void viewAttendance(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.viewAttendance(studentId);
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }
        System.out.println("Available Classrooms:");
        classrooms.keySet().forEach(System.out::println);
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listStudents();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
