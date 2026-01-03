import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface ListeningCategory {
  level: string;
  title: string;
  description: string;
  completed: number;
  total: number;
  action: string;
  link: string;
}

@Component({
  selector: 'app-listening',
  templateUrl: './listening.component.html',
  styleUrls: ['./listening.component.scss'],
})
export class ListeningComponent {
  today = {
    title: 'Chào hỏi nơi làm việc',
    duration: '45 giây',
    level: 'Beginner',
  };

  categories: ListeningCategory[] = [
    {
      level: 'Beginner',
      title: 'Hội thoại đời sống',
      description: 'Chào hỏi, ăn uống, sinh hoạt hằng ngày.',
      completed: 4,
      total: 10,
      action: 'Vào học',
      link: '111',
    },
    {
      level: 'Intermediate',
      title: 'Hội thoại công việc',
      description: 'Họp, trao đổi, phản hồi trong công việc.',
      completed: 2,
      total: 10,
      action: 'Vào học',
      link: '1111',
    },
    {
      level: 'Practice',
      title: 'Nghe & hiểu ý chính',
      description: 'Nghe nhanh – bắt ý – không cần hiểu từng từ.',
      completed: 0,
      total: 10,
      action: 'Bắt đầu',
      link: '11111',
    },
  ];

    constructor(private router: Router,) {}
  

  getProgress(item: ListeningCategory): number {
    return (item.completed / item.total) * 100;
  }

  goToList(link: string) {
    this.router.navigate(['study/listening/', link]);
  }
}
