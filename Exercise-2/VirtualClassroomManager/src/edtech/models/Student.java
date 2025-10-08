package edtech.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String studentId;
    private final Map<String, List<String>> submittedAssignments;
    private final Map<String, AttendanceRecord> attendanceRecords;

    public Student(String studentId) {
        this.studentId = studentId;
        this.submittedAssignments = new HashMap<>();
        this.attendanceRecords = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void submitAssignment(String className, String assignment) {
        submittedAssignments.putIfAbsent(className, new ArrayList<>());
        submittedAssignments.get(className).add(assignment);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
    }

    public void markAttendance(String className, LocalDate date, boolean isPresent) {
        attendanceRecords.putIfAbsent(className, new AttendanceRecord());
        attendanceRecords.get(className).markAttendance(date, isPresent);
        String status = isPresent ? "present" : "absent";
        System.out.println("Attendance marked: " + studentId + " is " + status + " for " + className + " on " + date);
    }

    public void viewAttendance(String className) {
        if (attendanceRecords.containsKey(className)) {
            System.out.println("Attendance for " + studentId + " in " + className + ":");
            attendanceRecords.get(className).getAttendance()
                    .forEach((date, present) -> System.out.println(date + " : " + (present ? "Present" : "Absent")));
        } else {
            System.out.println("No attendance record found for " + className);
        }
    }
}
