package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.user.internal.UserMapper;

/**
 * Mapper component responsible for converting between {@link Training} entities
 * and {@link TrainingDto} data transfer objects.
 * <p>
 * This class uses {@link UserMapper} to map the user associated with the training.
 * </p>
 */

@Component
@RequiredArgsConstructor
class TrainingMapper {

    private final UserMapper userMapper;

    TrainingDto toDto(Training training) {
        return new TrainingDto(
                training.getId(),
                userMapper.toDto(training.getUser()),
                training.getStartTime(),
                training.getEndTime(),
                training.getActivityType(),
                training.getDistance(),
                training.getAverageSpeed()
        );
    }
}