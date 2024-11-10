import { Component } from '@angular/core';
// import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';

import {FormsModule} from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import { ToolbarComponent } from './layout/toolbar/toolbar.component';
import { SidenavComponent } from './layout/sidenav/sidenav.component';
import { KeycloakAngularModule } from 'keycloak-angular';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HomeComponent, ToolbarComponent, SidenavComponent, FormsModule, 
    MatSidenavModule, 
    // HttpClientModule
    // KeycloakAngularModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  // title = 'edulluminate_frontend';


}
