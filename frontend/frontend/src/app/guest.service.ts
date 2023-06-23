import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Guest } from '../app/models/guest';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GuestService {
  private apiUrl = environment.apiUrl + '/parties';

  constructor(private http: HttpClient) { }

  getAllGuests(partyId: string): Observable<Guest[]> {
    const url = `${this.apiUrl}/${partyId}/guests`;
    return this.http.get<Guest[]>(url);
  }

  getGuestById(partyId: string, guestId: string): Observable<Guest> {
    const url = `${this.apiUrl}/${partyId}/guests/${guestId}`;
    return this.http.get<Guest>(url);
  }

  createGuest(partyId: string, guest: Guest): Observable<Guest> {
    const url = `${this.apiUrl}/${partyId}/guests`;
    return this.http.post<Guest>(url, guest);
  }

  updateGuest(partyId: string, guestId: string, guest: Guest): Observable<Guest> {
    const url = `${this.apiUrl}/${partyId}/guests/${guestId}`;
    return this.http.put<Guest>(url, guest);
  }

  deleteGuest(partyId: string, guestId: string): Observable<void> {
    const url = `${this.apiUrl}/${partyId}/guests/${guestId}`;
    return this.http.delete<void>(url);
  }
}
