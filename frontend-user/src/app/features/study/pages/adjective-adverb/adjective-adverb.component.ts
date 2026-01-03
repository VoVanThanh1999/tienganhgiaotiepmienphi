import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface WordItem {
  adjective: string;
  adverb: string;
  example: string;
}

@Component({
  selector: 'app-adjective-adverb',
  templateUrl: './adjective-adverb.component.html',
  styleUrls: ['./adjective-adverb.component.scss'],
})
export class AdjectiveAdverbComponent {
  filter = 'all';

  words: WordItem[] = [
    {
      adjective: 'quick',
      adverb: 'quickly',
      example: 'He is quick. / He runs quickly.',
    },
    {
      adjective: 'happy',
      adverb: 'happily',
      example: 'She is happy. / She speaks happily.',
    },
    {
      adjective: 'careful',
      adverb: 'carefully',
      example: 'Be careful. / Drive carefully.',
    },
    {
      adjective: 'good',
      adverb: 'well',
      example: 'She is good at math. / She speaks English well.',
    },
    {
      adjective: 'fast',
      adverb: 'fast',
      example: 'A fast car. / He drives fast.',
    },
  ];

  constructor(
    private router: Router
  ) {}

  goBack() {
    this.router.navigate(['study/adjective-adverb']);
  }

  get filteredWords() {
    if (this.filter === 'adj') {
      return this.words.filter(w => w.adjective);
    }
    if (this.filter === 'adv') {
      return this.words.filter(w => w.adverb);
    }
    return this.words;
  }

  goToDetail(base: string) {
    this.router.navigate(['study/adjective-adverb', base]);
  }

  
}
