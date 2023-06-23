package pl.edu.pwr.party_organizer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pwr.party_organizer.model.Guest;
import pl.edu.pwr.party_organizer.repository.GuestsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class GuestsServiceImpl implements GuestsService {
    @Autowired
    private GuestsRepository guestsRepository;

    @Override
    public Guest addGuest(Guest guest) {
        return guestsRepository.save(guest);
    }

    @Override
    public Guest deleteGuestById(Long guestId) {
        Optional<Guest> guest = guestsRepository.findById(guestId);
        guest.ifPresent(g -> guestsRepository.deleteById(guestId));
        return guest.get();
    }

    @Override
    public List<Guest> findAllGuests() {
        return guestsRepository.findAll();
    }

    @Override
    public Guest updateGuest(Guest guest) {
        Optional<Guest> existingGuest = guestsRepository.findById(guest.getId());
        existingGuest.ifPresent(g -> guestsRepository.save(guest));
        return existingGuest.get();
    }

    @Override
    public Guest findGuestById(Long guestId) {
        Optional<Guest> guest = guestsRepository.findById(guestId);
        return guest.get();
    }
}
