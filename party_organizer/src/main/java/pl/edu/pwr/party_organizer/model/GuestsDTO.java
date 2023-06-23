package pl.edu.pwr.party_organizer.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GuestsDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-17T07:25:17.089846400+02:00[Europe/Warsaw]")
public class GuestsDTO {
  public GuestsDTO (Long guestId, String name, String email){
    this.guestId = guestId;
    this.name = name;
    this.email = email;
  }

  @JsonProperty("guest_id")
  private Long guestId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  public GuestsDTO guestId(Long guestId) {
    this.guestId = guestId;
    return this;
  }

  /**
   * The identifier for the guest
   * @return guestId
  */
  @NotNull 
  @Schema(name = "guest_id", description = "The identifier for the guest", requiredMode = Schema.RequiredMode.REQUIRED)
  public Long getGuestId() {
    return guestId;
  }

  public void setGuestId(Long guestId) {
    this.guestId = guestId;
  }

  public GuestsDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the guest
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The name of the guest", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GuestsDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address of the guest
   * @return email
  */
  @NotNull 
  @Schema(name = "email", description = "The email address of the guest", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GuestsDTO guests = (GuestsDTO) o;
    return Objects.equals(this.guestId, guests.guestId) &&
        Objects.equals(this.name, guests.name) &&
        Objects.equals(this.email, guests.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestId, name, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GuestsDTO {\n");
    sb.append("    guestId: ").append(toIndentedString(guestId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

