package pl.edu.pwr.party_organizer.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwr.party_organizer.model.Party;



public interface PartiesService {
    Party addParty(Party party);
    Party deletePartyById(Long partyId);
    List<Party> findAllParties();
    Party updateParty(Party party);
    Party findPartyById(Long partyId);
}
