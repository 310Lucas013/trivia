import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TriviaQuestion} from '../../model/trivia-question';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {TriviaResult} from '../../model/trivia-result';
import {TriviaPickedAnswerDto} from '../../form-data/trivia-picked-answer-dto';

@Injectable({
  providedIn: 'root'
})
export class TriviaService {

  public triviaPath = environment.standardPath;

  public httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) { }

  public getTriviaQuestions(): Observable<TriviaQuestion[]> {
    return this.http.get<TriviaQuestion[]>(this.triviaPath + '/questions');
  }

  public checkAnswer(question: string, pickedAnswer: string): Observable<TriviaResult> {
    const triviaPickedAnswer = new TriviaPickedAnswerDto();
    triviaPickedAnswer.question = question;
    triviaPickedAnswer.pickedAnswer = pickedAnswer;
    const body = JSON.stringify(triviaPickedAnswer);
    const options = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };
    return this.http.post<TriviaResult>(this.triviaPath + '/checkanswer', body, options);
  }

}
