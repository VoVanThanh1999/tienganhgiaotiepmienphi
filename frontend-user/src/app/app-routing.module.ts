import { NgModule } from '@angular/core';
import { RouterModule, Routes, UrlMatcher, UrlSegment } from '@angular/router';

import { LANGUAGES } from './core/constants';
import { localizeRoute } from './core/guards';
import { AdminLayoutComponent } from './core/layouts/admin-layout/admin-layout.component';
import { UserLayoutComponent } from './core/layouts/user-layout/user-layout.component';
import { languageResolver } from './core/resolvers';
import { CustomRoutePreloadingStrategy } from './core/strategies';
import { ErrorComponent } from './shared/components';

const languageMatcher: UrlMatcher = (url: UrlSegment[]) => {
  const isAllowedLanguage =
    Array.isArray(url) && url.length && LANGUAGES.map(language => language.id).includes(url[0].path);
  return isAllowedLanguage ? { consumed: url.slice(0, 1) } : null;
};

/**
 * t(routes.default.title, routes.default.description)
 * t(routes.welcome.title, routes.welcome.description)
 * t(routes.jokes.title, routes.jokes.description)
 */
const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  {
    path: 'auth',
    component: UserLayoutComponent,
    loadChildren: () => import('./features/auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'study',
    component: UserLayoutComponent,
    loadChildren: () => import('./features/study/study.module').then(m => m.StudyModule),
  },
  {
    path: 'welcome',
    component: UserLayoutComponent,
    loadChildren: () => import('./features/home/home.module').then(m => m.HomeModule),
    data: {
      meta: {
        titleKey: 'routes.welcome.title',
        descriptionKey: 'routes.welcome.description'
      }
    }
  },
  {
    path: 'jokes',
    component: AdminLayoutComponent,
    loadChildren: () => import('./features/jokes/jokes.module').then(m => m.JokesModule),
    data: {
      preload: true,
      delayInSeconds: 10,
      meta: {
        titleKey: 'routes.jokes.title',
        descriptionKey: 'routes.jokes.description'
      }
    }
  },
  {
    path: '**',
    component: ErrorComponent,
    data: {
      revalidate: 0
    }
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          matcher: languageMatcher,
          children: routes,
          resolve: [languageResolver]
        },
        { path: '', canActivate: [localizeRoute], children: routes }
      ],
      {
        initialNavigation: 'enabledBlocking',
        scrollPositionRestoration: 'enabled',
        preloadingStrategy: CustomRoutePreloadingStrategy
      }
    )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
