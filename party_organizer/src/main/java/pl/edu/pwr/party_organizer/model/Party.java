package pl.edu.pwr.party_organizer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*; // for Spring Boot 3

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import pl.edu.pwr.party_organizer.model.Guest;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "parties")
public class Party {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @Column(name = "location")
  private String location;

  @OneToMany(mappedBy = "party")
  private List<Guest> guests = new ArrayList<>();

  @Column(name = "description")
  private String description;

  public Party id(Long id) {
    this.id = id;
    return this;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public List<Guest> getGuests() {
    return guests;
  }

  public void setGuests(List<Guest> guests) {
    this.guests = guests;
  }

  public String getPartyDescription() {
    return description;
  }

  public void setPartyDescription(String description) {
    this.description = description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Party(String name, Long id, String location) {
    this.name = name;
    this.id = id;
    this.location = location;
  }

  public Party(String name, Long id, String location, List<Guest> guests, String description) {
    this.name = name;
    this.id = id;
    this.location = location;
    this.guests = guests;
    this.description = description;
  }

  public Party() {
    this.name = "";
    this.id = 0L;
    this.location = "";
  }
}
