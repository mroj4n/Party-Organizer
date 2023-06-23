import { Component, OnInit } from '@angular/core';
import { Party } from '../models/party';
import { PartyService } from '../party.service';
import { Guest } from '../models/guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-party',
  templateUrl: './party.component.html',
  styleUrls: ['./party.component.css'],
})
export class PartyComponent implements OnInit {
  parties: Party[] = [];
  newParty: Party = {};
  guests: { [key: string]: Guest[] } = {};
  newGuest: { [key: string]: Guest } = {};

  constructor(
    private partyService: PartyService,
    private guestService: GuestService
  ) {}

  ngOnInit(): void {
    this.loadParties();
  }

  loadParties(): void {
    this.partyService.getAllParties().subscribe(
      (parties) => {
        this.parties = parties;
        parties.forEach((party) => {
          if (party.id) {
            this.newGuest[party.id] = {}; // initialize newGuest for each party
            this.guests[party.id] = []; // initialize guests for each party
          }
        });
      },
      (error) => {
        console.error('Error loading parties:', error);
      }
    );
  }

  addParty(): void {
    this.partyService.createParty(this.newParty).subscribe(
      (party) => {
        this.parties.push(party);
        this.newParty = {};
        if (party.id) {
          this.newGuest[party.id] = {}; // initialize newGuest for the new party
          this.guests[party.id] = []; // initialize guests for the new party
        }
      },
      (error) => {
        console.error('Error adding party:', error);
      }
    );
  }

  editParty(partyId: string | undefined): void {
    // Implement the logic for editing a party
    // You can navigate to a different component or show a modal for editing the party details
  }

  deleteParty(partyId: string | undefined): void {
    if (partyId) {
      this.partyService.deleteParty(partyId).subscribe(
        () => {
          this.parties = this.parties.filter((party) => party.id !== partyId);
        },
        (error) => {
          console.error('Error deleting party:', error);
        }
      );
    }
  }

  loadGuestsForParty(partyId: string | undefined): void {
    if (!partyId) {
      return;
    }
    this.guestService.getAllGuests(partyId).subscribe(
      (guests) => {
        this.guests[partyId] = guests;
      },
      (error) => {
        console.error('Error loading guests for party:', error);
      }
    );
  }

  addGuestToParty(partyId: string | undefined): void {
    if (!partyId || !this.newGuest[partyId]) {
      return;
    }
    this.guestService.createGuest(partyId, this.newGuest[partyId]).subscribe(
      (guest) => {
        this.guests[partyId].push(guest);
        this.newGuest[partyId] = {};
      },
      (error) => {
        console.error('Error adding guest to party:', error);
      }
    );
  }

  editGuest(guestId: string | undefined): void {
    // Implement the logic for editing a guest
    // You can navigate to a different component or show a modal for editing the guest details
  }

  deleteGuestFromParty(
    partyId: string | undefined,
    guestId: string | undefined
  ): void {
    if (!partyId || !guestId) {
      return;
    }
    this.guestService.deleteGuest(partyId, guestId).subscribe(
      () => {
        this.guests[partyId] = this.guests[partyId].filter(
          (guest) => guest.id !== guestId
        );
      },
      (error) => {
        console.error('Error deleting guest from party:', error);
      }
    );
  }
}
