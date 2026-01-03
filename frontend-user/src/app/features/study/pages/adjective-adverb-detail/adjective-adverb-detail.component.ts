import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-adjective-adverb-detail',
  templateUrl: './adjective-adverb-detail.component.html',
  styleUrls: ['./adjective-adverb-detail.component.scss']
})
export class AdjectiveAdverbDetailComponent {
  constructor(private location: Location) {}

  breadcrumb = {
    home: 'Trang chủ',
    previous: 'Tính từ & Trạng từ',
    current: 'quick / quickly',
  };

  data = {
    adjective: {
      word: 'quick',
      meaning: 'nhanh',
      examples: [
        {
          en: 'He is a quick learner.',
          vi: 'Anh ấy là người học rất nhanh.',
        },
        {
          en: 'That was a quick decision.',
          vi: 'Đó là một quyết định nhanh chóng.',
        },
      ],
    },
    adverb: {
      word: 'quickly',
      meaning: 'nhanh chóng',
      examples: [
        {
          en: 'He learns quickly.',
          vi: 'Anh ấy học rất nhanh.',
        },
        {
          en: 'Please reply quickly.',
          vi: 'Làm ơn trả lời nhanh.',
        },
      ],
    },
    note:
      'Một số tính từ và trạng từ có cùng hình thức (fast, hard, early), nhưng quick ≠ quickly nên cần chú ý.',
  };

  goBack() {
    this.location.back();
  }
}
