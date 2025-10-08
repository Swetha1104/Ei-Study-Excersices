class HOD extends ReviewHandler {
    
    public void review(ReEvaluationRequest request) {
        if (!request.isResolved()) {
            System.out.println("HOD reviewing " + request.getSubject() + " for " + request.getStudentName());
            
            request.setResolved(true);
            System.out.println("HOD resolved the request.");
        }
        if (!request.isResolved() && nextHandler != null) {
            nextHandler.review(request);
        }
    }
}
