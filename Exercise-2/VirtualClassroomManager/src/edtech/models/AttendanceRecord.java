package edtech.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Tracks attendance per date for a student within a class.
 */
public class AttendanceRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Map<LocalDate, Boolean> attendanceMap;

    public AttendanceRecord() {
        this.attendanceMap = new HashMap<>();
    }

    public void markAttendance(LocalDate date, boolean isPresent) {
        attendanceMap.put(date, isPresent);
    }

    public Map<LocalDate, Boolean> getAttendance() {
        return attendanceMap;
    }
}
