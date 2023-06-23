package pl.edu.pwr.party_organizer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*; // for Spring Boot 3

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guests")
public class Guest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @ManyToOne
  @JoinColumn(name = "party_id")
  private Party party; // Add the 'party' property
  // getters and setters

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
  
  // constructors

  public Guest() {
    this.name = "";
    this.email = "";
  }

  public Guest(String name, String email, long id) {
    this.name = name;
    this.email = email;
    this.id = id;
  }
  
}