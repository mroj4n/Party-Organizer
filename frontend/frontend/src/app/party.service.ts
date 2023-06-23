import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Party } from '../app/models/party';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PartyService {
  private apiUrl = environment.apiUrl; // Replace with your actual API endpoint URL

  constructor(private http: HttpClient) { }

  // Define methods to interact with the Party API

  // Example: Get all parties
  getAllParties(): Observable<Party[]> {
    return this.http.get<Party[]>(`${this.apiUrl}/parties`);
  }

  // Example: Get party by ID
  getPartyById(id: string): Observable<Party> {
    return this.http.get<Party>(`${this.apiUrl}/parties/${id}`);
  }

  // Example: Create a new party
  createParty(party: Party): Observable<Party> {
    return this.http.post<Party>(`${this.apiUrl}/parties`, party);
  }

  // Example: Update an existing party
  updateParty(id: string, party: Party): Observable<Party> {
    return this.http.put<Party>(`${this.apiUrl}/parties/${id}`, party);
  }

  // Example: Delete a party
  deleteParty(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/parties/${id}`);
  }
}
