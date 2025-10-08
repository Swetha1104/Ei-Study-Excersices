package modules;

import db.PatientDatabaseConnection;

public class BillingModule implements Runnable {
    private final String patientId;

    public BillingModule(String patientId) {
        this.patientId = patientId;
    }

    
    public void run() {
        PatientDatabaseConnection db = PatientDatabaseConnection.getInstance();
        System.out.println(Thread.currentThread().getName() + " BillingModule using " + db.getConnectionId());
        String data = db.readPatientRecord(patientId);
        System.out.println(Thread.currentThread().getName() + " BillingModule read: " + data);
    }
}
