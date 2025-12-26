package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.training.api.Training;

import java.util.List;
import java.util.Objects;

/**
 * Repository interface for data access operations on {@link Training} entities.
 * <p>
 * This interface is package-private and should not be accessed outside the 'internal' package.
 * It extends {@link JpaRepository} to provide standard CRUD operations.
 * </p>
 */

public interface TrainingRepository extends JpaRepository<Training, Long>
{
    default List<Training> findByUserId(Long userId) {
        return findAll().stream()
                .filter(training -> Objects.equals(training.getUser().getId(), userId))
                .toList();
    }
}
