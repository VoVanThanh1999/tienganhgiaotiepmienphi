import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface VerbDetail {
  base: string;
  past: string;
  pp: string;
  meaning: string;
  description: string;
  examples: string[];
}

interface Question {
  text: string;
  options: string[];
  answer: string;
}

@Component({
  selector: 'app-irregular-verb-detail',
  templateUrl: './irregular-verb-detail.component.html',
  styleUrls: ['./irregular-verb-detail.component.scss'],
})
export class IrregularVerbDetailComponent implements OnInit {
  verb!: VerbDetail;

  private data: VerbDetail[] = [
    {
      base: 'go',
      past: 'went',
      pp: 'gone',
      meaning: 'đi',
      description:
        'Go dùng để nói về việc di chuyển từ nơi này sang nơi khác.',
      examples: [
        'I go to work every day.',
        'Yesterday, I went to work late.',
        'I have gone to the office already.',
      ],
    },
  ];

  questions: Question[] = [
    {
      text: 'Yesterday, I ___ to school.',
      options: ['go', 'went', 'gone'],
      answer: 'went',
    },
    {
      text: 'I have ___ to the market already.',
      options: ['go', 'went', 'gone'],
      answer: 'gone',
    },
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const slug = this.route.snapshot.paramMap.get('verb');
    this.verb = this.data.find(v => v.base === slug)!;
  }

  selectedAnswers: Record<number, string> = {};

  selectAnswer(qIndex: number, option: string) {
    this.selectedAnswers[qIndex] = option;
  }

}
