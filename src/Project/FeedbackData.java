package Project;

public class FeedbackData {
    private int carID;
    private String feedback;

    public FeedbackData(int carID, String feedback) {
        this.carID = carID;
        this.feedback = feedback;
    }

    public int getCarID() { return carID; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}