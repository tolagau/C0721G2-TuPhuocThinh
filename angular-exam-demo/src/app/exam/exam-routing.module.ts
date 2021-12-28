import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ExamListComponent} from './exam-list/exam-list.component';
import {ExamCreateComponent} from './exam-create/exam-create.component';
import {ExamEditComponent} from './exam-edit/exam-edit.component';
import {ExamDetailComponent} from './exam-detail/exam-detail.component';
import {ExamDeleteComponent} from './exam-delete/exam-delete.component';


const routes: Routes = [
  {path: '', component: ExamListComponent},
  {path: 'create', component: ExamCreateComponent},
  {path: 'edit/:id', component: ExamEditComponent},
  {path: 'detail/:id', component: ExamDetailComponent},
  {path: 'delete/:id', component: ExamDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExamRoutingModule { }
