package com.lucas.trivia.services;

import com.lucas.trivia.models.TriviaAnswer;
import com.lucas.trivia.models.TriviaQuestion;
import com.lucas.trivia.models.TriviaResult;
import com.lucas.trivia.models.dto.ResultDto;
import com.lucas.trivia.models.dto.TriviaPickedAnswerDto;
import com.lucas.trivia.models.dto.TriviaQuestionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriviaService {

    private List<TriviaAnswer> triviaAnswerList;

    public TriviaService() {
    }

    public List<TriviaQuestion> getTriviaQuestionsAmountFromApi(int amount) {
        clearTriviaAnswerList();
        final String uri = "https://opentdb.com/api.php?amount=" + amount;

        RestTemplate restTemplate = new RestTemplate();
        TriviaQuestionDto triviaQuestionDto = restTemplate.getForObject(uri, TriviaQuestionDto.class);
        if (triviaQuestionDto != null && triviaQuestionDto.getResults() != null) {
            for (ResultDto resultDto : triviaQuestionDto.getResults()) {
                addTriviaAnswerList(new TriviaAnswer(resultDto));
            }
        }

        return getTriviaQuestionList();
    }

    public List<TriviaQuestion> getTriviaQuestionsFromApi() {
        return getTriviaQuestionsAmountFromApi(5);
    }

    public List<TriviaQuestion> getTriviaQuestionList() {
        List<TriviaQuestion> triviaQuestionList = new ArrayList<>();
        for (TriviaAnswer triviaAnswer: triviaAnswerList) {
            triviaQuestionList.add(triviaAnswer.getTriviaQuestion());
        }
        return triviaQuestionList;
    }

    public TriviaResult checkAnswer(TriviaPickedAnswerDto triviaPickedAnswerDto) {
        // Stream that gets the TriviaAnswer object that has the same question as the TriviaPickedAnswerDto object.
        TriviaAnswer currentTriviaAnswer = triviaAnswerList.stream()
                .filter(ta -> ta.getTriviaQuestion().getQuestion().equals(triviaPickedAnswerDto.getQuestion()))
                .collect(Collectors.toList())
                .get(0);
        return new TriviaResult(currentTriviaAnswer, triviaPickedAnswerDto.getPickedAnswer());
    }

    private void clearTriviaAnswerList() {
        this.triviaAnswerList = new ArrayList<>();
    }

    public void addTriviaAnswerList(TriviaAnswer triviaAnswer) {
        this.triviaAnswerList.add(triviaAnswer);
    }

    public List<TriviaAnswer> getTriviaAnswerList() {
        return triviaAnswerList;
    }

    public void setTriviaAnswerList(List<TriviaAnswer> triviaAnswerList) {
        this.triviaAnswerList = triviaAnswerList;
    }
}

