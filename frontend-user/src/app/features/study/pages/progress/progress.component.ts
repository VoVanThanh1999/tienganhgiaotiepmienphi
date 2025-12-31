import { Component } from '@angular/core';

@Component({
  selector: 'app-progress',
  templateUrl: './progress.component.html',
  styleUrls: ['./progress.component.scss']
})
export class ProgressComponent {
  overallProgress = 42;

  learnedLessons = 8;

  totalLessons = 19;

  streakDays = 5;

  skills = [
    { name: 'Ngữ pháp', percent: 60 },
    { name: 'Nghe', percent: 40 },
    { name: 'Nói', percent: 30 },
    { name: 'Từ vựng', percent: 50 }
  ];

  lessons = [
    { name: 'Present Simple', status: 'done' },
    { name: 'Present Continuous', status: 'done' },
    { name: 'Past Simple', status: 'learning' },
    { name: 'Present Perfect', status: 'locked' },
    { name: 'Future Simple', status: 'locked' }
  ];
}
