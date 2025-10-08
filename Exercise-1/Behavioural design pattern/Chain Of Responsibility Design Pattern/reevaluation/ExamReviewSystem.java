public class ExamReviewSystem {
    public static void main(String[] args) {
        // Request create
        ReEvaluationRequest request = new ReEvaluationRequest("Suresh", "Python Programming");

        // Handlers create
        ReviewHandler examiner = new Examiner();
        ReviewHandler hod = new HOD();
        ReviewHandler dean = new Dean();

        // Chain build
        examiner.setNextHandler(hod);
        hod.setNextHandler(dean);

        // Process start
        examiner.review(request);
    }
}
