import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ExamRoutingModule} from './exam-routing.module';
import {ExamListComponent} from './exam-list/exam-list.component';
import {ExamCreateComponent} from './exam-create/exam-create.component';
import {ExamEditComponent} from './exam-edit/exam-edit.component';
import {ExamDetailComponent} from './exam-detail/exam-detail.component';
import {ExamDeleteComponent} from './exam-delete/exam-delete.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [ExamListComponent,
    ExamCreateComponent,
    ExamEditComponent,
    ExamDetailComponent,
    ExamDeleteComponent],
  exports: [ExamListComponent],
  imports: [
    CommonModule,
    ExamRoutingModule,
    FormsModule,
    ReactiveFormsModule,


  ]
})
export class ExamModule {
}
