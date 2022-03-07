import { Component, OnInit } from '@angular/core';
import {TriviaQuestion} from '../shared/model/trivia-question';
import {TriviaService} from '../shared/service/trivia/trivia.service';
import {TriviaResult} from '../shared/model/trivia-result';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  triviaQuestions: TriviaQuestion[];
  triviaResult: TriviaResult;

  constructor(private triviaService: TriviaService) { }

  ngOnInit(): void {
    this.triviaService.getTriviaQuestions().subscribe(data => {
      console.log(data);
      this.triviaQuestions = data;
      }
    )
  }

  checkAnswer(question: string, pickedAnswer: string): void {
    this.triviaService.checkAnswer(question, pickedAnswer).subscribe(data => {
      this.triviaResult = data;
    })
  }

}
