import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LessonListComponent } from './pages/lesson-list/lesson-list.component';
import { ProgressComponent } from './pages/progress/progress.component';
import { TenseDetailComponent } from './pages/tense-detail/tense-detail.component';
import { TensesComponent } from './pages/tenses/tenses.component';

const routes: Routes = [
  { path: 'progress', component: ProgressComponent },
  { path: 'lessonlist', component: LessonListComponent },
  { path: 'tenses', component: TensesComponent },
  { path: 'tense-detail', component: TenseDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudyRoutingModule {}
