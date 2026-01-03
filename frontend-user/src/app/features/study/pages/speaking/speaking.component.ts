import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-speaking',
  templateUrl: './speaking.component.html',
  styleUrls: ['./speaking.component.scss'],
})
export class SpeakingComponent {
  header = {
    title: 'Luyện nói & phản xạ',
    subtitle: 'Nói ngắn – phản xạ nhanh – nói được trong đời sống & công việc.',
  };

  daily = {
    badge: '🎯 Speaking hôm nay',
    title: 'Giới thiệu bản thân nơi làm việc',
    level: 'Beginner',
    time: '30 giây',
  };

  categories = [
    {
      id: '111',
      level: 'Beginner',
      title: 'Nói theo chủ đề',
      desc: 'Gia đình, công việc, thói quen hằng ngày.',
      progress: 50,
      done: 5,
      total: 10,
      action: 'Vào luyện',
    },
    {
      id: '111',
      level: 'Intermediate',
      title: 'Phản xạ tình huống',
      desc: 'Hỏi – đáp nhanh trong giao tiếp thực tế.',
      progress: 20,
      done: 2,
      total: 10,
      action: 'Vào luyện',
    },
    {
      id: '111',
      level: 'Challenge',
      title: 'Speaking 60s',
      desc: 'Nói liên tục 60 giây không dừng.',
      progress: 0,
      done: 0,
      total: 0,
      action: 'Thử thách',
    },
  ];
  constructor(private router: Router) {}

  goToDetail(link: string) {
    this.router.navigate(['/study/speaking', link]);
  }
}
