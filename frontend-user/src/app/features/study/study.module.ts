import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { LessonListComponent } from './pages/lesson-list/lesson-list.component';
import { ProgressComponent } from './pages/progress/progress.component';
import { TenseDetailComponent } from './pages/tense-detail/tense-detail.component';
import { TensesComponent } from './pages/tenses/tenses.component';
import { StudyRoutingModule } from './study-routing.module';

@NgModule({
  declarations: [ProgressComponent, LessonListComponent, TensesComponent, TenseDetailComponent],
  imports: [CommonModule, StudyRoutingModule]
})
export class StudyModule {}
