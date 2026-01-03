import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";

import { LessonListComponent } from "./pages/lesson-list/lesson-list.component";
import { ProgressComponent } from "./pages/progress/progress.component";
import { TenseDetailComponent } from "./pages/tense-detail/tense-detail.component";
import { TensesComponent } from "./pages/tenses/tenses.component";
import { StudyRoutingModule } from "./study-routing.module";
import { StructuresComponent } from "./pages/structures/structures.component";
import { StructuresDetailComponent } from "./pages/structures-detail/structures-detail.component";
import { IrregularVerbsComponent } from "./pages/irregular-verbs/irregular-verbs.component";
import { FormsModule } from "@angular/forms";
import { VerbDetailComponent } from './pages/verb-detail/verb-detail.component';
import { IrregularVerbDetailComponent } from './pages/irregular-verb-detail/irregular-verb-detail.component';
import { ListeningComponent } from './pages/listening/listening.component';
import { ListeningListComponent } from './pages/listening-list/listening-list.component';
import { ListeningDetailComponent } from './pages/listening-detail/listening-detail.component';
import { SpeakingPracticeComponent } from './pages/speaking-practice/speaking-practice.component';
import { SpeakingComponent } from './pages/speaking/speaking.component';
import { SpeakingListComponent } from './pages/speaking-list/speaking-list.component';
import { AdjectiveAdverbComponent } from './pages/adjective-adverb/adjective-adverb.component';
import { AdjectiveAdverbDetailComponent } from './pages/adjective-adverb-detail/adjective-adverb-detail.component';
import { LessonDetailComponent } from './pages/lesson-detail/lesson-detail.component';

@NgModule({
  declarations: [
    ProgressComponent,
    LessonListComponent,
    TensesComponent,
    TenseDetailComponent,
    StructuresComponent,
    StructuresDetailComponent,
    IrregularVerbsComponent,
    VerbDetailComponent,
    IrregularVerbDetailComponent,
    ListeningComponent,
    ListeningListComponent,
    ListeningDetailComponent,
    SpeakingPracticeComponent,
    SpeakingComponent,
    SpeakingListComponent,
    AdjectiveAdverbComponent,
    AdjectiveAdverbDetailComponent,
    LessonDetailComponent,
  ],
  imports: [CommonModule, StudyRoutingModule, FormsModule],
})
export class StudyModule {}
