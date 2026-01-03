import { Component } from '@angular/core';

interface Feature {
  icon: string;
  title: string;
  desc: string;
}

interface Level {
  title: string;
  subtitle: string;
  result: string;
}

interface Knowledge {
  icon: string;
  title: string;
  desc: string;
  lblink: string;
  link: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  features: Feature[] = [
    {
      icon: '🗣',
      title: 'Giao tiếp đời sống',
      desc: 'Nói về công việc, cảm xúc, áp lực.'
    },
    {
      icon: '🎧',
      title: 'Nghe & Ngữ pháp',
      desc: 'Nghe ngắn mỗi ngày, ngữ pháp vừa đủ.'
    },
    {
      icon: '🤖',
      title: 'AI sửa phát âm',
      desc: 'Rèn phản xạ, nói rõ và tự tin.'
    }
  ];

  levels: Level[] = [
    {
      title: 'Beginner',
      subtitle: 'Câu đơn giản · Sinh hoạt',
      result: 'Bắt đầu nói được'
    },
    {
      title: 'Intermediate',
      subtitle: 'Giao tiếp công việc',
      result: 'Giao tiếp ổn định'
    },
    {
      title: 'Advanced',
      subtitle: 'Nói trôi chảy · Tự nhiên',
      result: 'Nói trôi chảy'
    }
  ];

  knowledgeList: Knowledge[] = [
    {
      icon: '🕒',
      title: 'Các thì hay dùng',
      desc: 'Hiện tại, quá khứ, tương lai qua ví dụ giao tiếp.',
      lblink: '→ Xem bài viết',
      link: 'tenses',

    },
    {
      icon: '🔁',
      title: 'Động từ bất quy tắc',
      desc: 'Học V1 · V2 · V3 theo ngữ cảnh.',
      lblink: '→ Xem danh sách',
      link: 'irregular-verbs',
    },
    {
      icon: '📝',
      title: 'Tính từ & Trạng từ',
      desc: 'Dùng đúng trong nói & viết.',
      lblink: '→ Xem chi tiết',
      link: 'adjective-adverb',
    },
    {
      icon: '📐',
      title: 'Cấu trúc câu',
      desc: 'too / enough, so / such, câu điều kiện…',
      lblink: '→ Xem cấu trúc',
      link: 'structures',
    },
    {
      icon: '🎧',
      title: 'Luyện nghe',
      desc: 'Nghe ngắn, quen âm, nói tự nhiên.',
      lblink: '→ Luyện nghe',
      link: 'listening',
    },
    {
      icon: '🗣',
      title: 'Luyện nói',
      desc: 'Nói về cảm xúc, công việc, đời sống.',
      lblink: '→ Luyện nói',
      link: 'speaking',

    }
  ];
}
