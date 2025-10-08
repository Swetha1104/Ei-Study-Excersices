abstract class ReviewHandler {
    protected ReviewHandler nextHandler;

    public void setNextHandler(ReviewHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void review(ReEvaluationRequest request);
}


