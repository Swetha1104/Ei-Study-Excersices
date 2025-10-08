package db;

public class PatientDatabaseConnection {
    private static volatile PatientDatabaseConnection instance = null;
    private boolean connected;       
    private String connectionId;

    private PatientDatabaseConnection() {
        this.connected = true;  
        this.connectionId = "CONN-" + System.currentTimeMillis();
        try {
            Thread.sleep(50); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("PatientDatabaseConnection created: " + connectionId);
    }

    public static PatientDatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (PatientDatabaseConnection.class) {
                if (instance == null) {
                    instance = new PatientDatabaseConnection();
                }
            }
        }
        return instance;
    }

    public String getConnectionId() {
        return connectionId;
    }

   
    public boolean isConnected() {
        return connected;
    }

    public synchronized void updatePatientRecord(String patientId, String data) {
        if (!connected) {
            System.out.println("Cannot update, database is not connected!");
            return;
        }
        System.out.printf("[%s] Updating patient %s with data: %s (using %s)%n",
                Thread.currentThread().getName(), patientId, data, connectionId);
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("[%s] Update complete for patient %s%n",
                Thread.currentThread().getName(), patientId);
    }

    public synchronized String readPatientRecord(String patientId) {
        if (!connected) {
            System.out.println("Cannot read, database is not connected!");
            return null;
        }
        System.out.printf("[%s] Reading patient %s (using %s)%n",
                Thread.currentThread().getName(), patientId, connectionId);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "PatientData(" + patientId + ")";
    }

   
    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected: " + connectionId);
    }
}
