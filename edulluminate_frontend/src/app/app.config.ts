import { APP_INITIALIZER, ApplicationConfig } from '@angular/core';
import { provideRouter, withRouterConfig } from '@angular/router';

import { routes } from './app.routes';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { KeycloakBearerInterceptor, KeycloakService } from 'keycloak-angular';
import { environment } from '../environments/environment';

function initializeKeycloak(keycloak: KeycloakService) {
  return async () => {
      try {
      keycloak.init({
        config: {
          url: environment.authServerUrl,
          realm: 'edulluminate',
          clientId: 'web'
        },
        initOptions: {
          onLoad: 'check-sso',
          silentCheckSsoRedirectUri:
            window.location.origin + '/assets/silent-check-sso.html'
        },
        shouldAddToken: (request) => {
          const { method, url } = request;
          
          const isPostRequest = 'POST' === method.toUpperCase();
          // debugger;
          return isPostRequest;
        },
        // enableBearerInterceptor: true,

      })
    }
    catch (error) {
      console.error(error);
      // https://github.com/mauriciovigolo/keycloak-angular/issues/201
    }
  }
}

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes, withRouterConfig({
    paramsInheritanceStrategy: 'always'
  })), provideAnimationsAsync(),
    provideHttpClient(withInterceptorsFromDi()),
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    }, 
    KeycloakService,

    {
      provide: HTTP_INTERCEPTORS,
      useClass: KeycloakBearerInterceptor,
      multi: true
     }
  ]
};

// https://angular.dev/guide/routing/common-router-tasks#defining-a-basic-route
// https://v17.angular.io/api/router/withRouterConfig
// https://stackoverflow.com/questions/78189625/providerouter-vs-routermodule-forroot-in-angular
// https://stackoverflow.com/questions/55411353/angular-get-value-of-parameter-in-parent-route
// https://stackoverflow.com/questions/42947133/parent-components-gets-empty-params-from-activatedroute


// https://pretius.com/blog/keycloak-angular-integration/

// interceptor
// https://stackoverflow.com/questions/77905410/configure-angular-17-standalone-to-work-with-keycloak
// https://stackoverflow.com/questions/71455341/keycloak-angular-interceptor-not-sending-authorization-header
// https://stackoverflow.com/questions/75945094/keycloak-angular-with-angularelements-and-standalone-component-no-authorization
// https://github.com/mauriciovigolo/keycloak-angular/issues/384
// https://lejdiprifti.com/2024/05/17/configure-keycloak-authentication-in-angular-17/
// https://pretius.com/blog/keycloak-angular-integration/
// https://medium.hexadefence.com/securing-an-angular-app-using-keycloak-bf48c5401246
// https://www.google.com/search?q=angular+17+keycloak+interceptor&oq=angular+17+keycloak+interceptor&gs_lcrp=EgZjaHJvbWUyCwgAEEUYChg5GKABMgkIARAhGAoYoAEyCQgCECEYChigAdIBCDYyNjJqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8


// https://www.keycloak.org/securing-apps/javascript-adapter
// https://jbcbezerra.hashnode.dev/setting-up-keycloak-authentication-in-angular-17-using-standalone-projects#heading-setting-up-authguard