package pl.edu.pwr.party_organizer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.pwr.party_organizer.model.Guest;
import pl.edu.pwr.party_organizer.model.GuestsDTO;
import pl.edu.pwr.party_organizer.model.Party;
import pl.edu.pwr.party_organizer.model.PartyDTO;
import pl.edu.pwr.party_organizer.service.PartiesService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PartiesController implements PartiesApi {

    private final PartiesService partiesService;

    @Autowired
    public PartiesController(PartiesService partiesService) {
        this.partiesService = partiesService;
    }

    @Override
    public ResponseEntity<Party> _createParty(Party party) {
        // Create the party using the partiesService
        Party createdParty = partiesService.addParty(party);
        return new ResponseEntity<>(createdParty, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> _deleteParty(String partyId) {
        // Delete the party using the partiesService
        Long partyLong = Long.valueOf(partyId);
        partiesService.deletePartyById(partyLong);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Party>> _getAllParties() {
        // Get all parties using the partiesService
        List<Party> parties = partiesService.findAllParties();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Party> _getPartyById(String partyId) {
        // Get the party by ID using the partiesService
        Long partyLong = Long.valueOf(partyId);
        Party party = partiesService.findPartyById(partyLong);
        if (party != null) {
            return new ResponseEntity<>(party, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Party> _updateParty(String partyId, Party party) {
        // Update the party using the partiesService
        Long partyLong = Long.valueOf(partyId);
        party.setId(partyLong);
        Party updatedParty = partiesService.updateParty(party);
        if (updatedParty != null) {
            return new ResponseEntity<>(updatedParty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
