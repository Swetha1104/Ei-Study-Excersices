class Dean extends ReviewHandler {
   
    public void review(ReEvaluationRequest request) {
        if (!request.isResolved()) {
            System.out.println("Dean reviewing " + request.getSubject() + " for " + request.getStudentName());
            request.setResolved(true);
            System.out.println("Dean resolved the request.");
        }
    }
}
