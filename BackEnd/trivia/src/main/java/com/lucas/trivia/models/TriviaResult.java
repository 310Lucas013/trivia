package com.lucas.trivia.models;

public class TriviaResult {
    private TriviaAnswer triviaAnswer;
    private String pickedAnswer;
    private Boolean correctAnswer;

    public TriviaResult() {
    }

    public TriviaResult(TriviaAnswer triviaAnswer, String pickedAnswer) {
        this.triviaAnswer = triviaAnswer;
        this.pickedAnswer = pickedAnswer;
        this.correctAnswer = triviaAnswer.getCorrectAnswer().equals(pickedAnswer);
    }

    public TriviaAnswer getTriviaAnswer() {
        return triviaAnswer;
    }

    public void setTriviaAnswer(TriviaAnswer triviaAnswer) {
        this.triviaAnswer = triviaAnswer;
    }

    public String getPickedAnswer() {
        return pickedAnswer;
    }

    public void setPickedAnswer(String pickedAnswer) {
        this.pickedAnswer = pickedAnswer;
    }

    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
