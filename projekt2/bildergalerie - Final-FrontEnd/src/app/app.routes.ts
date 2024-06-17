import { Routes } from '@angular/router';
import { UserPageComponent } from './UserPage/UserPage.component';
import { HomePageComponent } from './HomePage/HomePage.component';
import { UploadPageComponent } from './UploadPage/UploadPage.component';
import { PageNotFoundComponent } from './PageNotFound/PageNotFound.component';

export const routes: Routes = [
    { path: '', component: HomePageComponent },
    { path: 'userpage', component: UserPageComponent },
    { path: 'upload', component: UploadPageComponent },
    { path: '**', component: PageNotFoundComponent },  // Wildcard route for a 404 page

];
