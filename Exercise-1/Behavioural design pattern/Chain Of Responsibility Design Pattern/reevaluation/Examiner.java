class Examiner extends ReviewHandler {
   
    public void review(ReEvaluationRequest request) {
        if (!request.isResolved()) {
            System.out.println("Examiner reviewing " + request.getSubject() + " for " + request.getStudentName());
            
            request.setResolved(false);
        }
        if (nextHandler != null) {
            nextHandler.review(request);
        }
    }
}
