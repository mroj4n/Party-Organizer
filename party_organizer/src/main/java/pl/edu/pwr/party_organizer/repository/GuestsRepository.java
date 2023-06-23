package pl.edu.pwr.party_organizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.party_organizer.model.Guest;

public interface GuestsRepository extends JpaRepository<Guest, Long> {
}