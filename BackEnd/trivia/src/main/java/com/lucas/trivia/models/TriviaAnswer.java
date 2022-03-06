package com.lucas.trivia.models;

import com.lucas.trivia.models.dto.ResultDto;

public class TriviaAnswer {
    private String correctAnswer;
    private TriviaQuestion triviaQuestion;

    public TriviaAnswer() {
    }

    public TriviaAnswer(String correctAnswer, TriviaQuestion triviaQuestion) {
        this.correctAnswer = correctAnswer;
        this.triviaQuestion = triviaQuestion;
    }

    public TriviaAnswer(ResultDto resultDto) {
        this(resultDto.getCorrect_answer(), new TriviaQuestion(resultDto));
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public TriviaQuestion getTriviaQuestion() {
        return triviaQuestion;
    }

    public void setTriviaQuestion(TriviaQuestion triviaQuestion) {
        this.triviaQuestion = triviaQuestion;
    }
}
