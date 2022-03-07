package com.lucas.trivia.models;

import com.lucas.trivia.models.dto.ResultDto;
import com.lucas.trivia.models.dto.TriviaQuestionDto;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TriviaQuestion {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private List<String> answerOptions;

    public TriviaQuestion() {
    }

    public TriviaQuestion(String category, String type, String difficulty, String question, String correct_answer, List<String> incorrect_answers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        answerOptions = incorrect_answers;
        answerOptions.add(correct_answer);
        randomizeAnswerOptions();
    }

    public TriviaQuestion(ResultDto resultDto) {
        this(resultDto.getCategory(), resultDto.getType(), resultDto.getDifficulty(), resultDto.getQuestion(), resultDto.getCorrect_answer(), resultDto.getIncorrect_answers());
    }

    private void randomizeAnswerOptions() {
        Collections.shuffle(getAnswerOptions(), new Random());
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
