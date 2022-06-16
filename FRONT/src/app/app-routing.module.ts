import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { AuthGuardService } from './Services/authguard.service';
import { AccueilComponent } from './accueil/accueil.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { AllemployeesComponent } from './allemployees/allemployees.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { ScoresComponent } from './scores/scores.component';
import { UserinfoComponent } from './userinfo/userinfo.component';
import { RhprofileComponent } from './rhprofile/rhprofile.component';
import { UserScoreComponent } from './user-score/user-score.component';

const routes: Routes = [
  {path:'',component:AuthComponent},
  {path:'auth',component:AuthComponent},
  {path:'scores',component:ScoresComponent},
  {path:'user-scores',component:UserScoreComponent},
  {path:'all',component:AllemployeesComponent},
  {path:'user',component:UserinfoComponent},

  {path:'create', component:CreateUserComponent},
  {path:'user',component:UserprofileComponent,
  children: [
    {
    path: 'id',
    component:UserprofileComponent
    },
  ]},

  {path:'rh',component:RhprofileComponent,
  children: [
    {
    path: 'id',
    component:RhprofileComponent
    },
  ]},
  {path:'home',canActivate:[AuthGuardService],component:AccueilComponent,
  children: [
    {
    path: 'accueil',
    component:AccueilComponent
    },
  ]},
  {path:'notfound',component:NotfoundComponent},
  {path:'**',pathMatch:'full',redirectTo:'notfound'}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
