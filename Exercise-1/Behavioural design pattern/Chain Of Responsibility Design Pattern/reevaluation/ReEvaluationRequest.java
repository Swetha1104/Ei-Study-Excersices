class ReEvaluationRequest {
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
