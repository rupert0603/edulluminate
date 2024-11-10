import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

export const authGuard: CanActivateFn = async (route, state) => {
  const keycloak: KeycloakService = inject(KeycloakService);
  // console.log(keycloak);
  // await keycloak.login({
  //   redirectUri: window.location.origin + state.url
  // });

  // Check if the user is authenticated
  const isAuthenticated = keycloak.isLoggedIn();
  // debugger;
  // Force the user to log in if currently unauthenticated.
  if (!isAuthenticated) {
    debugger;
    await keycloak.login({
      redirectUri: window.location.origin + state.url
    });
  }

  // Get the roles assigned to the user
  const roles = keycloak.getUserRoles(true);

  // Get the roles required from the route data
  const requiredRoles = route.data['roles'];

  // Allow the user to proceed if no additional roles are required to access the route.
  if (!Array.isArray(requiredRoles) || requiredRoles.length === 0) {
    return true;
  }

  // Allow the user to proceed if all the required roles are present.
  return requiredRoles.every((role) => roles.includes(role));
};

// https://jbcbezerra.hashnode.dev/setting-up-keycloak-authentication-in-angular-17-using-standalone-projects#heading-setting-up-authguard
// https://medium.com/ngconf/functional-route-guards-in-angular-8829f0e4ca5c
// https://lejdiprifti.com/2024/05/17/configure-keycloak-authentication-in-angular-17/

// https://stackoverflow.com/questions/75658903/how-to-implement-angular-auth-guard
// https://stackoverflow.com/questions/77600996/how-to-import-keycloak-module-using-standalone-components-and-without-ngmodule
// https://stackoverflow.com/questions/77905410/configure-angular-17-standalone-to-work-with-keycloak

// https://medium.com/@jaydeepvpatil225/auth-guards-in-angular-6960950b3c6c
// https://www.youtube.com/watch?v=6_tRwY52Llg

// https://stackoverflow.com/questions/55758490/display-components-if-there-is-an-authenticated-user
// https://keycloak.discourse.group/t/redirect-to-keycloak-on-button-click-using-angular/3937

// https://pretius.com/blog/keycloak-angular-integration/
// https://www.yourteaminindia.com/blog/angular-authentication-using-route-guards
