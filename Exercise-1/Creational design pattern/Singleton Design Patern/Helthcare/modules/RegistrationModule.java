package modules;

import db.PatientDatabaseConnection;

public class RegistrationModule implements Runnable {
    private final String patientId;

    public RegistrationModule(String patientId) {
        this.patientId = patientId;
    }

    @Override
    public void run() {
        PatientDatabaseConnection db = PatientDatabaseConnection.getInstance();
        System.out.println(Thread.currentThread().getName() + " RegistrationModule using " + db.getConnectionId());
        db.updatePatientRecord(patientId, "Registered: Basic Info");
    }
}
