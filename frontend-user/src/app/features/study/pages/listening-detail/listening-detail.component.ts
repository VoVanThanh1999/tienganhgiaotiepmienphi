import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface Question {
  question: string;
  options: string[];
  answer: number;
}

@Component({
  selector: 'app-listening-detail',
  templateUrl: './listening-detail.component.html',
  styleUrls: ['./listening-detail.component.scss'],
})
export class ListeningDetailComponent implements OnInit {
  showTranscript = false;

  lesson = {
    title: 'Luyện nghe giao tiếp',
    level: 'Beginner',
    duration: '45s',
    topic: 'Chào hỏi nơi làm việc',
    transcript: [
      { speaker: 'A', text: 'Hi, how are you today?' },
      { speaker: 'B', text: "I'm good, thanks. How about you?" },
      { speaker: 'A', text: 'Ready for the meeting?' },
      { speaker: 'B', text: "Yes, let's get started." },
    ],
  };

  questions: Question[] = [
    {
      question: 'Where does the conversation take place?',
      options: ['At home', 'At work', 'At a cafe'],
      answer: 1,
    },
    {
      question: 'What are they preparing for?',
      options: ['A meeting', 'A trip', 'Lunch'],
      answer: 0,
    },
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const lessonId = this.route.snapshot.queryParamMap.get('lessonId');
    console.log('Lesson ID:', lessonId);
  }

  toggleTranscript() {
    this.showTranscript = !this.showTranscript;
  }
}
