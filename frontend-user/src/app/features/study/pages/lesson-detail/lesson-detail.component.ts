import { Component } from '@angular/core';

interface Vocabulary {
  word: string;
  ipa: string;
  meaning: string;
  example: string;
}

@Component({
  selector: 'app-lesson-detail',
  templateUrl: './lesson-detail.component.html',
  styleUrls: ['./lesson-detail.component.scss'],
})
export class LessonDetailComponent {
  showNote = false;
  noteTab: 'write' | 'history' = 'write';

  lesson = {
    day: 22,
    title: 'Making Decisions & Choices',
    description:
      'Diễn đạt quyết định, lựa chọn và lý do — rất hay dùng trong giao tiếp & phỏng vấn.',
    level: 'B1 → B1+',
    duration: '15–20 phút',
    skill: 'Speaking',
    heroImage:
      'https://images.unsplash.com/photo-1529333166437-7750a6dd5a70',
  };

  objectives = [
    'Dùng decide / choose / prefer / would rather đúng ngữ cảnh',
    'Nói rõ vì sao chọn A thay vì B',
    'Rèn phản xạ nói B1',
  ];

  vocabularies: Vocabulary[] = [
    {
      word: 'decide',
      ipa: '/dɪˈsaɪd/',
      meaning: 'quyết định',
      example: 'I decided to learn English.',
    },
    {
      word: 'choose',
      ipa: '/tʃuːz/',
      meaning: 'chọn',
      example: 'I chose this option.',
    },
    {
      word: 'prefer',
      ipa: '/prɪˈfɜːr/',
      meaning: 'thích hơn',
      example: 'I prefer studying at night.',
    },
  ];

  grammarRules = [
    'decide to + V1 → I decided to learn English.',
    'prefer A to B → I prefer coffee to tea.',
    'would rather A than B → I’d rather learn English than watch TV.',
  ];

  listeningVideos = [
    {
      title: 'How to Make Better Decisions',
      url: 'https://www.youtube.com/embed/5C0bA3cJQYI',
    },
    {
      title: 'Talking About Choices (B1)',
      url: 'https://www.youtube.com/embed/2bZ6sZ6nOaA',
    },
  ];

  shadowingScript = [
    'Every day, I have to make many decisions.',
    'Sometimes I choose to study instead of relaxing.',
    'I prefer learning English at night.',
    'When I choose growth over comfort, I grow faster.',
  ];

  toggleNote() {
    this.showNote = !this.showNote;
  }

  switchTab(tab: 'write' | 'history') {
    this.noteTab = tab;
  }
}
