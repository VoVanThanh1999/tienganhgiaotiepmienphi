import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

interface Verb {
  base: string;
  past: string;
  pp: string;
  meaning: string;
  example: string;
  level: 'BEGINNER' | 'INTERMEDIATE';
}

@Component({
  selector: 'app-irregular-verbs',
  templateUrl: './irregular-verbs.component.html',
  styleUrls: ['./irregular-verbs.component.scss'],
})
export class IrregularVerbsComponent implements OnInit {
  levels = ['ALL', 'BEGINNER', 'INTERMEDIATE'];
  selectedLevel = 'ALL';

  verbs: Verb[] = [
    {
      base: 'go',
      past: 'went',
      pp: 'gone',
      meaning: 'đi',
      example: 'I go to work every day.',
      level: 'BEGINNER',
    },
    {
      base: 'see',
      past: 'saw',
      pp: 'seen',
      meaning: 'nhìn thấy',
      example: 'I saw her yesterday.',
      level: 'BEGINNER',
    },
    {
      base: 'take',
      past: 'took',
      pp: 'taken',
      meaning: 'lấy / mang',
      example: 'I took a photo.',
      level: 'INTERMEDIATE',
    },
  ];

  // pagination
  currentPage = 1;
  pageSize = 2;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  goToDetail(base: string) {
    this.router.navigate(['study/irregular-verb', base]);
  }

  get filteredVerbs(): Verb[] {
    if (this.selectedLevel === 'ALL') return this.verbs;
    return this.verbs.filter(v => v.level === this.selectedLevel);
  }

  get pagedVerbs(): Verb[] {
    const start = (this.currentPage - 1) * this.pageSize;
    return this.filteredVerbs.slice(start, start + this.pageSize);
  }

  get totalPages(): number[] {
    return Array(Math.ceil(this.filteredVerbs.length / this.pageSize))
      .fill(0)
      .map((_, i) => i + 1);
  }

  goToPage(page: number) {
    this.currentPage = page;
  }
}
