package com.lucas.trivia.models.dto;

public class TriviaPickedAnswerDto {
    private String question;
    private String pickedAnswer;

    public TriviaPickedAnswerDto() {
    }

    public TriviaPickedAnswerDto(String question, String pickedAnswer) {
        this.question = question;
        this.pickedAnswer = pickedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPickedAnswer() {
        return pickedAnswer;
    }

    public void setPickedAnswer(String pickedAnswer) {
        this.pickedAnswer = pickedAnswer;
    }
}
