package edtech.persistence;

import edtech.models.Classroom;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple persistence manager using Java serialization.
 */
public class PersistenceManager {
    private static final Logger LOGGER = Logger.getLogger(PersistenceManager.class.getName());
    private static final String DATA_DIR = "data";
    private static final String DATA_FILE = DATA_DIR + File.separator + "classrooms_data.ser";

    public static void saveData(Map<String, Classroom> classrooms) {
        try {
            Path dataDir = Path.of(DATA_DIR);
            if (!Files.exists(dataDir)) Files.createDirectories(dataDir);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
                oos.writeObject(classrooms);
            }
            LOGGER.info("Data saved successfully to " + DATA_FILE);
            System.out.println("[INFO] Data saved successfully.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to save data", e);
            System.err.println("[ERROR] Failed to save data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Classroom> loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            LOGGER.info("No existing data file found. Starting with empty dataset.");
            System.out.println("[INFO] No existing data found. Starting fresh.");
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                LOGGER.info("Data loaded successfully from " + DATA_FILE);
                System.out.println("[INFO] Data loaded successfully.");
                return (Map<String, Classroom>) obj;
            } else {
                LOGGER.warning("Unexpected data format in " + DATA_FILE);
            }
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Failed to load data, starting fresh", e);
            System.err.println("[ERROR] Failed to load data: " + e.getMessage());
        }
        return new HashMap<>();
    }
}
