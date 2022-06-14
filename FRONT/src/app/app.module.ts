import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NotfoundComponent } from './notfound/notfound.component';
import { AuthGuardService } from './Services/authguard.service';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'; 
import { AuthenticationService } from './Services/authentication.service';
import { BasicAuthHttpInterceptorService } from './Services/basic-auth-http-interceptor.service';
import { AccueilComponent } from './accueil/accueil.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { AllemployeesComponent } from './allemployees/allemployees.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from "./app.material-module";
import { UserprofileComponent } from './userprofile/userprofile.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon';
import { ScoresComponent } from './scores/scores.component';
import { UserinfoComponent } from './userinfo/userinfo.component';
import { RhprofileComponent } from './rhprofile/rhprofile.component';
import { UserScoreComponent } from './user-score/user-score.component'


@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    NotfoundComponent,
    AccueilComponent,
    CreateUserComponent,
    AllemployeesComponent,
    UserprofileComponent,
    ScoresComponent,
    UserinfoComponent,
    RhprofileComponent,
    UserScoreComponent,
  ],
  imports: [
    MatIconModule,
    MatButtonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AngularFontAwesomeModule,
    HttpClientModule,
    BrowserAnimationsModule,AppMaterialModule,MatToolbarModule,MatSidenavModule
  ],
  
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BasicAuthHttpInterceptorService,
      multi: true
    },AuthGuardService,HttpClientModule,AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
