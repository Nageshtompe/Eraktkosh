import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UIUserData } from './model/UIUserData';
import { UserdashboardComponent } from './dashboard/userdashboard/userdashboard.component';
import { UserServiceService } from './services/user-service.service';
import { UserdashboardComponantModule } from './userdashboard-componant/userdashboard-componant.module';
import { AboutusModule } from './aboutus/aboutus.module';
import { FooterModule } from './footer/footer.module';
import { AdminModule } from './admin/admin.module';
import { UserModule } from './user/user.module';
import { HistoryModule } from './history/history.module';
import { RootModule } from './root/root.module';

@NgModule({
  declarations: [
    AppComponent,
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    DashboardModule,
    UserdashboardComponantModule,
    AboutusModule,
    FooterModule,
    HttpClientModule,
    AdminModule,
    UserModule,
    FooterModule,
    HistoryModule,
    RootModule
   
  ],
  providers: [UIUserData,UserServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }


// LoginModule,
// DashboardModule,
// UserdashboardComponantModule,
// AboutusModule,
// FooterModule,
// HttpClientModule,
// AdminModule,
// UserModule