/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package pl.edu.pwr.party_organizer.api;

import pl.edu.pwr.party_organizer.model.GuestsDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

import pl.edu.pwr.party_organizer.model.Guest;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-22T02:40:28.913336600+02:00[Europe/Warsaw]")
@Validated
@Tag(name = "Guests", description = "Operations related to guests")
public interface GuestsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /parties/{partyId}/guests : Add a guest to a party
     *
     * @param partyId ID of the party (required)
     * @param guest Guest details (required)
     * @return Guest added successfully (status code 201)
     *         or Invalid input (status code 400)
     *         or Party not found (status code 404)
     */
    @Operation(
        operationId = "addGuestToParty",
        summary = "Add a guest to a party",
        tags = { "Guests" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Guest added successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Guest.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Party not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/parties/{partyId}/guests",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Guest> _addGuestToParty(
        @Parameter(name = "partyId", description = "ID of the party", required = true, in = ParameterIn.PATH) @PathVariable("partyId") String partyId,
        @Parameter(name = "Guest", description = "Guest details", required = true) @Valid @RequestBody Guest guest
    ) {
        return addGuestToParty(partyId, guest);
    }

    // Override this method
    default  ResponseEntity<Guest> addGuestToParty(String partyId, Guest guest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"987e6543-e21b-34d5-c654-098765432100\", \"email\" : \"john.doe@example.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /parties/{partyId}/guests/{guestId} : Delete guest
     *
     * @param partyId ID of the party (required)
     * @param guestId ID of the guest (required)
     * @return Guest deleted successfully (status code 204)
     *         or Guest or party not found (status code 404)
     */
    @Operation(
        operationId = "deleteGuest",
        summary = "Delete guest",
        tags = { "Guests" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Guest deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Guest or party not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/parties/{partyId}/guests/{guestId}"
    )
    default ResponseEntity<Void> _deleteGuest(
        @Parameter(name = "partyId", description = "ID of the party", required = true, in = ParameterIn.PATH) @PathVariable("partyId") String partyId,
        @Parameter(name = "guestId", description = "ID of the guest", required = true, in = ParameterIn.PATH) @PathVariable("guestId") String guestId
    ) {
        return deleteGuest(partyId, guestId);
    }

    // Override this method
    default  ResponseEntity<Void> deleteGuest(String partyId, String guestId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /parties/{partyId}/guests/{guestId} : Get guest by ID
     *
     * @param partyId ID of the party (required)
     * @param guestId ID of the guest (required)
     * @return Successful operation (status code 200)
     *         or Guest or party not found (status code 404)
     */
    @Operation(
        operationId = "getGuestById",
        summary = "Get guest by ID",
        tags = { "Guests" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Guest.class))
            }),
            @ApiResponse(responseCode = "404", description = "Guest or party not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/parties/{partyId}/guests/{guestId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Guest> _getGuestById(
        @Parameter(name = "partyId", description = "ID of the party", required = true, in = ParameterIn.PATH) @PathVariable("partyId") String partyId,
        @Parameter(name = "guestId", description = "ID of the guest", required = true, in = ParameterIn.PATH) @PathVariable("guestId") String guestId
    ) {
        return getGuestById(partyId, guestId);
    }

    // Override this method
    default  ResponseEntity<Guest> getGuestById(String partyId, String guestId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"987e6543-e21b-34d5-c654-098765432100\", \"email\" : \"john.doe@example.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /parties/{partyId}/guests : Get guests of a party
     *
     * @param partyId ID of the party (required)
     * @return Successful operation (status code 200)
     *         or Party not found (status code 404)
     */
    @Operation(
        operationId = "getPartyGuests",
        summary = "Get guests of a party",
        tags = { "Guests" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Guest.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Party not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/parties/{partyId}/guests",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Guest>> _getPartyGuests(
        @Parameter(name = "partyId", description = "ID of the party", required = true, in = ParameterIn.PATH) @PathVariable("partyId") String partyId
    ) {
        return getPartyGuests(partyId);
    }

    // Override this method
    default  ResponseEntity<List<Guest>> getPartyGuests(String partyId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"name\" : \"John Doe\", \"id\" : \"987e6543-e21b-34d5-c654-098765432100\", \"email\" : \"john.doe@example.com\" }, { \"name\" : \"John Doe\", \"id\" : \"987e6543-e21b-34d5-c654-098765432100\", \"email\" : \"john.doe@example.com\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /parties/{partyId}/guests/{guestId} : Update guest
     *
     * @param partyId ID of the party (required)
     * @param guestId ID of the guest (required)
     * @param guest Guest details (required)
     * @return Guest updated successfully (status code 200)
     *         or Invalid input (status code 400)
     *         or Guest or party not found (status code 404)
     */
    @Operation(
        operationId = "updateGuest",
        summary = "Update guest",
        tags = { "Guests" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Guest updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Guest.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Guest or party not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/parties/{partyId}/guests/{guestId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Guest> _updateGuest(
        @Parameter(name = "partyId", description = "ID of the party", required = true, in = ParameterIn.PATH) @PathVariable("partyId") String partyId,
        @Parameter(name = "guestId", description = "ID of the guest", required = true, in = ParameterIn.PATH) @PathVariable("guestId") String guestId,
        @Parameter(name = "Guest", description = "Guest details", required = true) @Valid @RequestBody Guest guest
    ) {
        return updateGuest(partyId, guestId, guest);
    }

    // Override this method
    default  ResponseEntity<Guest> updateGuest(String partyId, String guestId, Guest guest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"987e6543-e21b-34d5-c654-098765432100\", \"email\" : \"john.doe@example.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
