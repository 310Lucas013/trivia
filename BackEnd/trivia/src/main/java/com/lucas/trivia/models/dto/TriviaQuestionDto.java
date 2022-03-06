package com.lucas.trivia.models.dto;

import java.util.List;

public class TriviaQuestionDto {
    private int response_code;
    private List<ResultDto> results;

    public TriviaQuestionDto() {
    }

    public TriviaQuestionDto(int response_code, List<ResultDto> results) {
        this.response_code = response_code;
        this.results = results;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<ResultDto> getResults() {
        return results;
    }

    public void setResults(List<ResultDto> results) {
        this.results = results;
    }
}
