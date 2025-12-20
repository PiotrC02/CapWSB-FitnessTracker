package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) used for transferring {@link pl.wsb.fitnesstracker.user.api.User} data.
 * <p>
 * This record is used to separate the internal database entity from the data exposed
 * via the API. It handles JSON formatting for date fields.
 * </p>
 *
 * @param id        the unique identifier of the user (nullable for new users not yet persisted)
 * @param firstName the user's first name
 * @param lastName  the user's last name
 * @param birthdate the user's date of birth (serialized in "yyyy-MM-dd" format)
 * @param email     the user's email address
 */

public record UserDto(@Nullable Long id, String firstName, String lastName,
                      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                      String email) {

}
