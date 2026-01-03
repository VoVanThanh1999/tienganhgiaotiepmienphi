import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface Example {
  en: string;
  vi: string;
}

interface StructureLesson {
  title: string;
  intro: string;
  too?: Example[];
  enough?: Example[];
  note?: string;
}

@Component({
  selector: 'app-structure-detail',
  templateUrl: './structures-detail.component.html',
  styleUrls: ['./structures-detail.component.scss'],
})
export class StructuresDetailComponent implements OnInit {
  slug!: string;
  lesson!: StructureLesson;

  private lessons: Record<string, StructureLesson> = {
    'too-enough': {
      title: 'Too / Enough',
      intro:
        'Cấu trúc too và enough dùng để nói về mức độ quá / đủ để làm một việc gì đó.',
      too: [
        {
          en: 'I’m too tired to work.',
          vi: 'Tôi quá mệt để làm việc.',
        },
        {
          en: 'This box is too heavy to carry.',
          vi: 'Cái hộp này quá nặng để mang.',
        },
      ],
      enough: [
        {
          en: 'I’m strong enough to lift it.',
          vi: 'Tôi đủ khỏe để nhấc nó.',
        },
        {
          en: 'She speaks well enough to communicate.',
          vi: 'Cô ấy nói đủ tốt để giao tiếp.',
        },
      ],
      note:
        'Không dùng too và enough chung trong cùng một câu.',
    },

    'so-such': {
      title: 'So / Such',
      intro:
        'So và Such dùng để nhấn mạnh mức độ của tính từ hoặc danh từ.',
      note:
        'So + adjective, Such + a/an + noun',
    },
  };

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.slug = params.get('slug') ?? '';
      this.lesson = this.lessons[this.slug];

      if (!this.lesson) {
        console.warn('Lesson not found:', this.slug);
      }
    });
  }
}
