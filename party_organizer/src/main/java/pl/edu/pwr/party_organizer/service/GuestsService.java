package pl.edu.pwr.party_organizer.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pl.edu.pwr.party_organizer.model.Guest;

public interface GuestsService {
    Guest addGuest(Guest guest);
    Guest deleteGuestById(Long guestId);
    List<Guest> findAllGuests();
    Guest updateGuest(Guest guest);
    Guest findGuestById(Long guestId);
}
