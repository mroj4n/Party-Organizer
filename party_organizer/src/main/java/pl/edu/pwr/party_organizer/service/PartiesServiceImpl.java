package pl.edu.pwr.party_organizer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pwr.party_organizer.model.Party;
import pl.edu.pwr.party_organizer.repository.PartiesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PartiesServiceImpl implements PartiesService {
    @Autowired
    private PartiesRepository partiesRepository;

    @Override
    public Party addParty(Party party) {
        return partiesRepository.save(party);
    }

    @Override
    public Party deletePartyById(Long partyId) {
        Optional<Party> party = partiesRepository.findById(partyId);
        party.ifPresent(p -> partiesRepository.deleteById(partyId));
        return party.get();
    }

    @Override
    public List<Party> findAllParties() {
        return partiesRepository.findAll();
    }

    @Override
    public Party updateParty(Party party) {
        Optional<Party> existingParty = partiesRepository.findById(party.getId());
        existingParty.ifPresent(p -> partiesRepository.save(party));
        return existingParty.get();
    }

    @Override
    public Party findPartyById(Long partyId) {
        Optional<Party> party = partiesRepository.findById(partyId);
        return party.get();
    }
}
