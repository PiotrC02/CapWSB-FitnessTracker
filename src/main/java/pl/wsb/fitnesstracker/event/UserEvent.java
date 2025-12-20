package pl.wsb.fitnesstracker.event;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User;

/**
 * Entity representing the association between a {@link User} and an {@link Event}.
 * This class maps to the "UserEvent" table and allows tracking the status of
 * a user's participation in a specific event.
 */

@Entity
@Table(name = "UserEvent")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "status")
    private String status;

    public UserEvent(final Long id, final User user, final Event event, final String status) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.status = status;
    }
}
