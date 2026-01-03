import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

interface SpeakingItem {
  id: number;
  title: string;
  duration: number;
  level: 'Beginner' | 'Intermediate';
  status: 'new' | 'done';
}

@Component({
  selector: 'app-speaking-list',
  templateUrl: './speaking-list.component.html',
  styleUrls: ['./speaking-list.component.scss'],
})
export class SpeakingListComponent {
  levelFilter = 'all';

  items: SpeakingItem[] = [
    {
      id: 1,
      title: 'Giới thiệu bản thân nơi làm việc',
      duration: 30,
      level: 'Beginner',
      status: 'new',
    },
    {
      id: 2,
      title: 'Nói về công việc hằng ngày',
      duration: 45,
      level: 'Beginner',
      status: 'done',
    },
    {
      id: 3,
      title: 'Mô tả một ngày bận rộn',
      duration: 60,
      level: 'Intermediate',
      status: 'new',
    },
    {
      id: 4,
      title: 'Trình bày ý kiến trong cuộc họp',
      duration: 60,
      level: 'Intermediate',
      status: 'new',
    },
  ];

  constructor(private router: Router,
        private route: ActivatedRoute
    
  ) {}

  get filteredItems() {
    if (this.levelFilter === 'all') return this.items;
    return this.items.filter(i => i.level === this.levelFilter);
  }

  goToDetail(item: SpeakingItem) {
    const category = this.route.snapshot.paramMap.get('categoryId');

    this.router.navigate(['/study/speaking', category, item.id]);
  }
}
