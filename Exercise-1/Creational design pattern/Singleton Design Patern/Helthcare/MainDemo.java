import modules.*;
import db.PatientDatabaseConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Healthcare Singleton Demo...");

        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.submit(new RegistrationModule("P1001"));
        executor.submit(new BillingModule("P1001"));
        executor.submit(new PharmacyModule("P1001"));

        executor.submit(new RegistrationModule("P2002"));
        executor.submit(new BillingModule("P2002"));
        executor.submit(new PharmacyModule("P2002"));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        PatientDatabaseConnection db1 = PatientDatabaseConnection.getInstance();
        PatientDatabaseConnection db2 = PatientDatabaseConnection.getInstance();
        System.out.println("db1 id: " + db1.getConnectionId());
        System.out.println("db2 id: " + db2.getConnectionId());
        System.out.println("Same instance? " + (db1 == db2));

        System.out.println("Demo finished.");
    }
}
