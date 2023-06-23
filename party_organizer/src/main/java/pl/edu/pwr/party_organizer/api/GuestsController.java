package pl.edu.pwr.party_organizer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.party_organizer.model.Guest;
import pl.edu.pwr.party_organizer.model.GuestsDTO;
import pl.edu.pwr.party_organizer.service.GuestsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GuestsController implements GuestsApi {

    private final GuestsService guestsService;

    @Autowired
    public GuestsController(GuestsService guestsService) {
        this.guestsService = guestsService;
    }

    @Override
    public ResponseEntity<Guest> addGuestToParty(String partyId, Guest guest) {
        // Add the guest to the party using the guestsService
        Guest addedGuest = guestsService.addGuest(guest);
        return new ResponseEntity<>(addedGuest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteGuest(String partyId, String guestId) {
        // Delete the guest from the party using the guestsService
        Long guestLong = Long.valueOf(guestId);
        guestsService.deleteGuestById(guestLong);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Guest> getGuestById(String partyId, String guestId) {
        // Get the guest by ID from the party using the guestsService
        Long guestLong = Long.valueOf(guestId);
        Guest guest = guestsService.findGuestById(guestLong);
        if (guest != null) {
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Guest>> getPartyGuests(String partyId) {
        // Get all guests of the party using the guestsService
        List<Guest> guests = guestsService.findAllGuests();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Guest> updateGuest(String partyId, String guestId, Guest guest) {
        // Update the guest in the party using the guestsService
        guest.setId(Long.valueOf(guestId));
        Guest updatedGuest = guestsService.updateGuest(guest);
        if (updatedGuest != null) {
            return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
