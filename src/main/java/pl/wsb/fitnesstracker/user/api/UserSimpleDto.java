package pl.wsb.fitnesstracker.user.api;

/**
 * Data Transfer Object (DTO) containing a simplified view of a {@link pl.wsb.fitnesstracker.user.api.User}.
 * <p>
 * This record is used for operations where only basic identity information (name and ID)
 * is required, omitting sensitive details like email or birthdate.
 * </p>
 *
 * @param id        the unique identifier of the user
 * @param firstName the user's first name
 * @param lastName  the user's last name
 */

public record UserSimpleDto(Long id, String firstName, String lastName) {
}