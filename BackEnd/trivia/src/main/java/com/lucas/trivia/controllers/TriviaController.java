package com.lucas.trivia.controllers;

import com.google.gson.Gson;
import com.lucas.trivia.models.TriviaQuestion;
import com.lucas.trivia.models.TriviaResult;
import com.lucas.trivia.models.dto.TriviaPickedAnswerDto;
import com.lucas.trivia.services.TriviaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:4200")
public class TriviaController {

    private final TriviaService triviaService;

    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping(value = "/questions")
    public ResponseEntity<String> getTriviaQuestions() {
        List<TriviaQuestion> triviaQuestionList = triviaService.getTriviaQuestionsFromApi();
        Gson gson = new Gson();
        String result = gson.toJson(triviaQuestionList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/questions/{amount}")
    public ResponseEntity<String> getAmountOfTriviaQuestions(@PathVariable("amount") int amount) {
        List<TriviaQuestion> triviaQuestionList = triviaService.getTriviaQuestionsAmountFromApi(amount);
        Gson gson = new Gson();
        String result = gson.toJson(triviaQuestionList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/checkanswer")
    public ResponseEntity<String> checkAnswer(@RequestBody TriviaPickedAnswerDto triviaPickedAnswerDto) {
        TriviaResult triviaResult = triviaService.checkAnswer(triviaPickedAnswerDto);
        Gson gson = new Gson();
        String result = gson.toJson(triviaResult);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
