package edtech;

import edtech.manager.VirtualClassroomManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("edtech");

    public static void main(String[] args) {
        configureLogging();

        VirtualClassroomManager manager = VirtualClassroomManager.getInstance();

        try (Scanner sc = new Scanner(System.in)) {
            printWelcome();
            while (true) {
                System.out.print("> ");
                String input = sc.nextLine().trim();
                if (input.isEmpty()) continue;

                String[] parts = input.split(" ", 3);
                String command = parts[0].toLowerCase();

                try {
                    switch (command) {
                        case "add_classroom":
                            if (parts.length >= 2) manager.addClassroom(parts[1]);
                            else System.out.println("Usage: add_classroom <name>");
                            break;

                        case "remove_classroom":
                            if (parts.length >= 2) manager.removeClassroom(parts[1]);
                            else System.out.println("Usage: remove_classroom <name>");
                            break;

                        case "add_student":
                            // Expecting: add_student <id> <class>
                            if (parts.length >= 3) {
                                String[] p = input.split(" ", 4);
                                manager.addStudent(p[1], p[2]);
                            } else {
                                System.out.println("Usage: add_student <id> <class>");
                            }
                            break;

                        case "schedule_assignment":
                            // schedule_assignment <class> <assignment text...>
                            if (parts.length >= 3) manager.scheduleAssignment(parts[1], parts[2]);
                            else System.out.println("Usage: schedule_assignment <class> <assignment>");
                            break;

                        case "submit_assignment":
                            // submit_assignment <id> <class> <assignment...>
                            {
                                String[] p = input.split(" ", 4);
                                if (p.length >= 4) manager.submitAssignment(p[1], p[2], p[3]);
                                else System.out.println("Usage: submit_assignment <id> <class> <assignment>");
                            }
                            break;

                        case "mark_attendance":
                            // mark_attendance <id> <class> <present/absent>
                            {
                                String[] p = input.split(" ", 4);
                                if (p.length >= 4) {
                                    boolean isPresent = p[3].equalsIgnoreCase("present");
                                    manager.markAttendance(p[1], p[2], LocalDate.now(), isPresent);
                                } else {
                                    System.out.println("Usage: mark_attendance <id> <class> <present/absent>");
                                }
                            }
                            break;

                        case "view_attendance":
                            // view_attendance <id> <class>
                            if (parts.length >= 3) manager.viewAttendance(parts[1], parts[2]);
                            else System.out.println("Usage: view_attendance <id> <class>");
                            break;

                        case "list_classrooms":
                            manager.listClassrooms();
                            break;

                        case "list_students":
                            if (parts.length >= 2) manager.listStudents(parts[1]);
                            else System.out.println("Usage: list_students <class>");
                            break;

                        case "exit":
                            System.out.println("Exiting Virtual Classroom Manager. Goodbye!");
                            LOGGER.info("Application exited by user.");
                            return;

                        default:
                            System.out.println("Unknown command. Type 'help' to see available commands.");
                    }
                } catch (Exception e) {
                    System.err.println("[ERROR] " + e.getMessage());
                    LOGGER.log(Level.SEVERE, "Exception while processing command", e);
                }
            }
        }
    }

    private static void printWelcome() {
        System.out.println("Welcome to Virtual Classroom Manager!");
        System.out.println("Commands:");
        System.out.println("  add_classroom <name>");
        System.out.println("  remove_classroom <name>");
        System.out.println("  add_student <id> <class>");
        System.out.println("  schedule_assignment <class> <assignment>");
        System.out.println("  submit_assignment <id> <class> <assignment>");
        System.out.println("  mark_attendance <id> <class> <present/absent>");
        System.out.println("  view_attendance <id> <class>");
        System.out.println("  list_classrooms");
        System.out.println("  list_students <class>");
        System.out.println("  exit");
    }

    private static void configureLogging() {
        try {
            Path logsDir = Path.of("logs");
            if (!Files.exists(logsDir)) Files.createDirectories(logsDir);
            FileHandler fh = new FileHandler("logs/app.log", true);
            fh.setFormatter(new SimpleFormatter());
            Logger root = Logger.getLogger("");
            root.addHandler(fh);
            root.setLevel(Level.INFO);
            LOGGER.info("Logging configured.");
        } catch (IOException e) {
            System.err.println("[WARN] Could not create log file: " + e.getMessage());
        }
    }
}
