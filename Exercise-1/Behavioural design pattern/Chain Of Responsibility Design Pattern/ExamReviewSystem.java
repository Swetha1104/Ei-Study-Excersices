public class ExamReviewSystem {

    // Request class
    static class ReEvaluationRequest {
        private String studentName;
        private String subject;
        private boolean resolved;

        public ReEvaluationRequest(String studentName, String subject) {
            this.studentName = studentName;
            this.subject = subject;
            this.resolved = false;
        }

        public String getStudentName() { return studentName; }
        public String getSubject() { return subject; }
        public boolean isResolved() { return resolved; }
        public void setResolved(boolean resolved) { this.resolved = resolved; }
    }

    // Abstract handler
    static abstract class ReviewHandler {
        protected ReviewHandler nextHandler;

        public void setNextHandler(ReviewHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public abstract void review(ReEvaluationRequest request);
    }

    // Examiner handler
    static class Examiner extends ReviewHandler {
        @Override
        public void review(ReEvaluationRequest request) {
            if (!request.isResolved()) {
                System.out.println("Examiner reviewing " + request.getSubject() + " for " + request.getStudentName());
                request.setResolved(false);
            }
            if (nextHandler != null) nextHandler.review(request);
        }
    }

    // HOD handler
    static class HOD extends ReviewHandler {
        @Override
        public void review(ReEvaluationRequest request) {
            if (!request.isResolved()) {
                System.out.println("HOD reviewing " + request.getSubject() + " for " + request.getStudentName());
                request.setResolved(true);
                System.out.println("HOD resolved the re-evaluation request successfully.");
            } else {
                System.out.println("HOD: Request already resolved by a previous level.");
            }
        }
    }

    // Dean handler
    static class Dean extends ReviewHandler {
        @Override
        public void review(ReEvaluationRequest request) {
            if (!request.isResolved()) {
                System.out.println("Dean reviewing " + request.getSubject() + " for " + request.getStudentName());
                request.setResolved(true);
                System.out.println("Dean resolved the re-evaluation request finally.");
            } else {
                System.out.println("Dean: Request already resolved before reaching me.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        ReviewHandler examiner = new Examiner();
        ReviewHandler hod = new HOD();
        ReviewHandler dean = new Dean();

        examiner.setNextHandler(hod);
        hod.setNextHandler(dean);

        ReEvaluationRequest request = new ReEvaluationRequest("Abinaya", "Data Structures");

        examiner.review(request);

        if (request.isResolved()) {
            System.out.println("Re-evaluation request successfully handled.");
        } else {
            System.out.println("Request could not be resolved.");
        }
    }
}
