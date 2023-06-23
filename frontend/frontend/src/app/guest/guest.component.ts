import { Component, OnInit } from '@angular/core';
import { Guest } from '../models/guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-guest',
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {
  guests: Guest[] = [];
  newGuest: Guest = {};

  constructor(private guestService: GuestService) { }

  ngOnInit(): void {
    this.loadGuests();
  }

  loadGuests(): void {
    const partyId = 'your-party-id'; // Replace with the actual party ID
    this.guestService.getAllGuests(partyId).subscribe(
      (guests) => {
        this.guests = guests;
      },
      (error) => {
        console.error('Error loading guests:', error);
      }
    );
  }

  addGuest(): void {
    const partyId = 'your-party-id'; // Replace with the actual party ID
    this.guestService.createGuest(partyId, this.newGuest).subscribe(
      (guest) => {
        this.guests.push(guest);
        this.newGuest = {}; // Clear the newGuest object after successful addition
      },
      (error) => {
        console.error('Error adding guest:', error);
      }
    );
  }

  editGuest(guestId: string | undefined): void {
    // Implement the logic for editing a guest
    // You can navigate to a different component or show a modal for editing the guest details
  }

  deleteGuest(guestId: string | undefined): void {
    if (guestId) {
      const partyId = 'your-party-id'; // Replace with the actual party ID
      this.guestService.deleteGuest(partyId, guestId).subscribe(
        () => {
          this.guests = this.guests.filter(guest => guest.id !== guestId);
        },
        (error) => {
          console.error('Error deleting guest:', error);
        }
      );
    }
  }
}
