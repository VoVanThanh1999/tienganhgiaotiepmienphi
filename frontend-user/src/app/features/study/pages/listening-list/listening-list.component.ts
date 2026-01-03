import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

interface ListeningItem {
  id: number;
  title: string;
  duration: number;
  level: 'Beginner' | 'Intermediate';
  status: 'done' | 'new';
}

@Component({
  selector: 'app-listening-list',
  templateUrl: './listening-list.component.html',
  styleUrls: ['./listening-list.component.scss'],
})
export class ListeningListComponent {
  levelFilter = 'ALL';

  items: ListeningItem[] = [
    {
      id: 1,
      title: 'Chào hỏi nơi làm việc',
      duration: 45,
      level: 'Beginner',
      status: 'new',
    },
    {
      id: 2,
      title: 'Hỏi thăm đồng nghiệp',
      duration: 60,
      level: 'Beginner',
      status: 'done',
    },
    {
      id: 3,
      title: 'Chuẩn bị cho cuộc họp',
      duration: 75,
      level: 'Intermediate',
      status: 'new',
    },
    {
      id: 4,
      title: 'Phản hồi công việc',
      duration: 90,
      level: 'Intermediate',
      status: 'new',
    },
  ];

  constructor(private router: Router,
    private route: ActivatedRoute
  ) {}

  get filteredItems() {
    if (this.levelFilter === 'ALL') return this.items;
    return this.items.filter(i => i.level === this.levelFilter);
  }

  goToDetail(item: ListeningItem) {
    const category = this.route.snapshot.paramMap.get('categoryId');
    this.router.navigate(['study/listening',category, item.id]);
  }
}
