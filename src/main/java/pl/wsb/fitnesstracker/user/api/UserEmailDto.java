package pl.wsb.fitnesstracker.user.api;

/**
 * Data Transfer Object (DTO) used for simplified user lookups, containing only the ID and email address.
 * <p>
 * This record is typically used in search operations where returning the full user profile
 * is unnecessary or restricted.
 * </p>
 *
 * @param id    the unique identifier of the user
 * @param email the user's email address
 */

public record UserEmailDto(Long id, String email) {
}