import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LessonListComponent } from './pages/lesson-list/lesson-list.component';
import { ProgressComponent } from './pages/progress/progress.component';
import { TenseDetailComponent } from './pages/tense-detail/tense-detail.component';
import { TensesComponent } from './pages/tenses/tenses.component';
import { StructuresComponent } from './pages/structures/structures.component';
import { StructuresDetailComponent } from './pages/structures-detail/structures-detail.component';
import { IrregularVerbsComponent } from './pages/irregular-verbs/irregular-verbs.component';
import { IrregularVerbDetailComponent } from './pages/irregular-verb-detail/irregular-verb-detail.component';
import { ListeningComponent } from './pages/listening/listening.component';
import { ListeningListComponent } from './pages/listening-list/listening-list.component';
import { ListeningDetailComponent } from './pages/listening-detail/listening-detail.component';
import { SpeakingComponent } from './pages/speaking/speaking.component';
import { SpeakingListComponent } from './pages/speaking-list/speaking-list.component';
import { SpeakingPracticeComponent } from './pages/speaking-practice/speaking-practice.component';
import { AdjectiveAdverbComponent } from './pages/adjective-adverb/adjective-adverb.component';
import { AdjectiveAdverbDetailComponent } from './pages/adjective-adverb-detail/adjective-adverb-detail.component';
import { LessonDetailComponent } from './pages/lesson-detail/lesson-detail.component';

const routes: Routes = [
  { path: 'progress', component: ProgressComponent },
  { path: 'lessonlist', component: LessonListComponent },
  { path: 'lesson/:id', component: LessonDetailComponent },
  { path: 'tenses', component: TensesComponent },
  { path: 'tense/:slug', component: TenseDetailComponent },
  { path: 'structures', component: StructuresComponent },
  { path: 'structure/:slug', component: StructuresDetailComponent },
  { path: 'irregular-verbs', component: IrregularVerbsComponent },
  { path: 'irregular-verb/:verb', component: IrregularVerbDetailComponent },
  { path: 'adjective-adverb', component:  AdjectiveAdverbComponent},
  { path: 'adjective-adverb/:verb', component: AdjectiveAdverbDetailComponent },
  { path: 'listening', component: ListeningComponent },
  { path: 'listening/:categoryId', component: ListeningListComponent },
  { path: 'listening/:categoryId/:lessonId', component: ListeningDetailComponent },
  { path: 'speaking', component:  SpeakingComponent},
  { path: 'speaking/:categoryId', component: SpeakingListComponent },
  { path: 'speaking/:categoryId/:lessonId', component: SpeakingPracticeComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudyRoutingModule {}
