import { Component } from '@angular/core';

interface TenseItem {
  badge: string;
  title: string;
  use: string;
  example: string;
  meaning: string;
}

@Component({
  selector: 'app-tenses',
  templateUrl: './tenses.component.html',
  styleUrls: ['./tenses.component.scss']
})
export class TensesComponent {
  tenses: TenseItem[] = [
    {
      // eslint-disable-next-line sonarjs/no-duplicate-string
      badge: 'Rất hay dùng',
      title: 'Present Simple (Hiện tại đơn)',
      use: 'Dùng để nói về thói quen, sự thật, công việc hằng ngày.',
      example: 'I work as a Java developer.',
      meaning: 'Tôi làm lập trình viên Java.'
    },
    {
      badge: 'Rất hay dùng',
      title: 'Present Continuous (Hiện tại tiếp diễn)',
      use: 'Dùng để nói việc đang xảy ra ngay lúc nói.',
      example: 'I am learning English now.',
      meaning: 'Tôi đang học tiếng Anh.'
    },
    {
      badge: 'Rất hay dùng',
      title: 'Past Simple (Quá khứ đơn)',
      use: 'Dùng để kể chuyện đã xảy ra trong quá khứ.',
      example: 'I worked at FPT last year.',
      meaning: 'Tôi đã làm ở FPT năm ngoái.'
    },
    {
      badge: 'Hay dùng',
      title: 'Future Simple (Tương lai đơn)',
      use: 'Dùng để nói dự định, quyết định tức thời.',
      example: 'I will practice English tonight.',
      meaning: 'Tối nay tôi sẽ luyện tiếng Anh.'
    },
    {
      badge: 'Hay dùng',
      title: 'Present Perfect (Hiện tại hoàn thành)',
      use: 'Dùng để nói trải nghiệm, việc đã làm nhưng còn liên quan hiện tại.',
      example: 'I have learned Java for 2 years.',
      meaning: 'Tôi đã học Java được 2 năm.'
    },
    {
      badge: 'Nâng cao',
      title: 'Past Continuous (Quá khứ tiếp diễn)',
      use: 'Dùng để mô tả hành động đang xảy ra trong quá khứ.',
      example: 'I was studying when you called.',
      meaning: 'Tôi đang học thì bạn gọi.'
    }
  ];
}
