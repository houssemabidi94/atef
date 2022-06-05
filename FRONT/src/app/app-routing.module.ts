import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { AuthGuardService } from './Services/authguard.service';
import { AccueilComponent } from './accueil/accueil.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { AllemployeesComponent } from './allemployees/allemployees.component';
import { UserprofileComponent } from './userprofile/userprofile.component';

const routes: Routes = [
  {path:'',component:AuthComponent},
  {path:'auth',component:AuthComponent},
  {path:'all',component:AllemployeesComponent},
  {path:'user',component:UserprofileComponent},

  {path:'create', component:CreateUserComponent},
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
