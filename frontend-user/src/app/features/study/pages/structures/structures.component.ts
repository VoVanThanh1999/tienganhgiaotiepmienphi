import { Component } from '@angular/core';

interface SentenceStructure {
  title: string;
  formula: string;
  example: string;
  slug: string,
}

@Component({
  selector: 'app-structures',
  templateUrl: './structures.component.html',
  styleUrls: ['./structures.component.scss'],
})
export class StructuresComponent {
  structures: SentenceStructure[] = [
    {
      title: 'Too / Enough',
      formula: 'too + adj/adv + to V',
      example: 'I’m too tired to work.',
      slug: 'too-enough',
    },
    {
      title: 'So / Such',
      formula: 'so + adj / such + a/an + noun',
      example: 'It’s so hot today.',
      slug: 'too-enough',
    },
    {
      title: 'Would rather',
      formula: 'would rather + V',
      example: 'I’d rather stay home.',
      slug: 'too-enough',
    },
    {
      title: 'Used to',
      formula: 'used to + V',
      example: 'I used to smoke.',
      slug: 'too-enough',
    },
    {
      title: 'Because / So',
      formula: 'because + clause',
      example: 'I stayed home because it rained.',
      slug: 'too-enough',
    },
    {
      title: 'In order to',
      formula: 'in order to + V',
      example: 'I study English to improve my job.',
      slug: 'too-enough',
    },

  ];
}
