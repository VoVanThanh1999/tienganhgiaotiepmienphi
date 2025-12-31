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
      link: '→ Xem bài viết'
    },
    {
      icon: '🔁',
      title: 'Động từ bất quy tắc',
      desc: 'Học V1 · V2 · V3 theo ngữ cảnh.',
      link: '→ Xem danh sách'
    },
    {
      icon: '📝',
      title: 'Tính từ & Trạng từ',
      desc: 'Dùng đúng trong nói & viết.',
      link: '→ Xem chi tiết'
    },
    {
      icon: '📐',
      title: 'Cấu trúc câu',
      desc: 'too / enough, so / such, câu điều kiện…',
      link: '→ Xem cấu trúc'
    },
    {
      icon: '🎧',
      title: 'Luyện nghe',
      desc: 'Nghe ngắn, quen âm, nói tự nhiên.',
      link: '→ Luyện nghe'
    },
    {
      icon: '🗣',
      title: 'Luyện nói',
      desc: 'Nói về cảm xúc, công việc, đời sống.',
      link: '→ Luyện nói'
    }
  ];
}
