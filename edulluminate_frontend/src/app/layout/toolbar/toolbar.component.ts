import { Component, EventEmitter, inject, Output } from '@angular/core';
import { RouterModule, Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { filter } from 'rxjs';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';

import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-toolbar',
  standalone: true,
  imports: [MatToolbarModule, MatIconModule, MatButtonModule, RouterModule, CommonModule],
  templateUrl: './toolbar.component.html',
  styleUrl: './toolbar.component.scss'
})
export class ToolbarComponent {
  url = '';
  // keycloak: KeycloakService = inject(KeycloakService);

  regexBookChapterRoute = /books\/\d+?\/chapter\/\d+?/

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    protected readonly keycloak: KeycloakService
  ) {
    // console.log(this.router);
    // this.url = this.router.url;
    // https://stackoverflow.com/questions/33520043/how-to-detect-a-route-change-in-angular
    router.events
      .pipe(
        filter((event: any) => event instanceof NavigationEnd)
      )
      .subscribe((event: NavigationEnd) => {
        this.url = event.url;
      });
  }

  @Output() sideNavToggleEvent: EventEmitter<any> = new EventEmitter();

  toggle() {
    this.sideNavToggleEvent.emit();
  }

  async login() {
    try{
      await this.keycloak.login({
        redirectUri: window.location.origin + this.router.routerState.snapshot.url
      });
    } catch (error) {
      console.error('Login error:', error);
    }
  }

  register(){
    this.keycloak.register({
      redirectUri: window.location.origin + this.router.routerState.snapshot.url
    });
  }
  
  async logout(){
    this.keycloak.logout(window.location.origin + this.router.routerState.snapshot.url);
  }
}

// https://stackoverflow.com/questions/78780922/keycloak-angular-with-standalone-components-this-instance-undefined-causing-typ
// remove KeycloakAngularModule in imports in AppComponent.ts
// https://groups.google.com/g/angular/c/dGyFJE2ilfQ
// https://stackoverflow.com/questions/77905410/configure-angular-17-standalone-to-work-with-keycloak