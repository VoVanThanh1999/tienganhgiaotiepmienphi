import { Component } from '@angular/core';

interface Example {
  en: string;
  vi: string;
}

interface Mistake {
  wrong: string;
  correct: string;
}

@Component({
  selector: 'app-tense-detail',
  templateUrl: './tense-detail.component.html',
  styleUrls: ['./tense-detail.component.scss']
})
export class TenseDetailComponent {
  tense = {
    badge: 'Rất hay dùng',
    title: 'Present Simple – Hiện tại đơn',
    description:
      'Đây là thì quan trọng nhất trong giao tiếp. Nếu bạn dùng đúng thì này, bạn đã nói tiếng Anh ổn hơn 60% người học.',

    when: ['Thói quen hằng ngày', 'Công việc, nghề nghiệp', 'Sự thật hiển nhiên', 'Lịch trình cố định'],

    structure: {
      affirmative: 'S + V(s/es) + O',
      negative: 'S + do/does not + V',
      question: 'Do/Does + S + V ?'
    },

    examples: [
      {
        en: 'I work as a Java developer.',
        vi: 'Tôi làm lập trình viên Java.'
      },
      {
        en: 'I usually wake up at 6 a.m.',
        vi: 'Tôi thường dậy lúc 6 giờ.'
      },
      {
        en: 'My company uses Spring Boot.',
        vi: 'Công ty tôi dùng Spring Boot.'
      }
    ] as Example[],

    mistakes: [
      {
        wrong: 'I work at FPT now.',
        correct: 'I am working at FPT now.'
      },
      {
        wrong: 'He work as a developer.',
        correct: 'He works as a developer.'
      }
    ] as Mistake[]
  };
}
