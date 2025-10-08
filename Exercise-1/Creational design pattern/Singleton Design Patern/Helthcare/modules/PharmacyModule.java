package modules;

import db.PatientDatabaseConnection;

public class PharmacyModule implements Runnable {
    private final String patientId;

    public PharmacyModule(String patientId) {
        this.patientId = patientId;
    }

   
    public void run() {
        PatientDatabaseConnection db = PatientDatabaseConnection.getInstance();
        System.out.println(Thread.currentThread().getName() + " PharmacyModule using " + db.getConnectionId());
        db.updatePatientRecord(patientId, "Prescribed: Medicine A");
    }
}
