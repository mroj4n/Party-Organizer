import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuestComponent } from './guest/guest.component';
import { PartyComponent } from './party/party.component';

const routes: Routes = [
  { path: 'guests', component: GuestComponent },
  { path: 'parties', component: PartyComponent },
  // Other routes if needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
