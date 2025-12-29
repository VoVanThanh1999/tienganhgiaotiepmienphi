import { Component } from '@angular/core';

@Component({
  selector: 'app-lesson-list',
  templateUrl: './lesson-list.component.html',
  styleUrls: ['./lesson-list.component.scss']
})
export class LessonListComponent {
  tabs = ['Beginner', 'Intermediate', 'Advanced'];

  activeTab = 'Beginner';

  lessons = [
    {
      title: 'Lesson 1 – Nói về cảm xúc khi mệt mỏi',
      level: 'A1',
      levelClass: 'a1',
      time: '15 phút',
      topic: 'Cảm xúc',
      tags: ['Listening', 'Grammar', 'Speaking'],
      done: false,
      img: 'https://images.unsplash.com/photo-1522202176988-66273c2fd55f'
    },
    {
      title: 'Lesson 2 – Diễn đạt áp lực công việc',
      level: 'A2',
      levelClass: 'a2',
      time: '18 phút',
      topic: 'Công việc',
      tags: ['Listening', 'Speaking'],
      done: true,
      img: 'https://images.unsplash.com/photo-1515378791036-0648a3ef77b2'
    },
    {
      title: 'Lesson 3 – Nói về thói quen hằng ngày',
      level: 'B1',
      levelClass: 'b1',
      time: '12 phút',
      topic: 'Sinh hoạt',
      tags: ['Grammar', 'Speaking'],
      done: false,
      img: 'https://images.unsplash.com/photo-1491841550275-ad7854e35ca6'
    }
  ];
}
