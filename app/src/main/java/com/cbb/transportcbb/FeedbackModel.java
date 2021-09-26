package com.cbb.transportcbb;

public class FeedbackModel {

    String id;
    String email;
    String feedback;

    public FeedbackModel() {
    }

    public FeedbackModel(String id, String email, String feedback) {
        this.id = id;
        this.email = email;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
