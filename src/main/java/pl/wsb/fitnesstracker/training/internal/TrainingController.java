package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;

import java.util.List;

/**
 * REST Controller responsible for exposing training-related operations.
 * <p>
 * This controller provides endpoints to retrieve training data, acting as the interface
 * between the external clients (API consumers) and the internal application logic.
 * </p>
 */

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
class TrainingController {

    private final TrainingProvider trainingProvider;
    private final TrainingMapper trainingMapper;

    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingProvider.findAllTrainings().stream()
                .map(trainingMapper::toDto)
                .toList();
    }

    @GetMapping("/{userId}")
    public List<TrainingDto> getTrainingsByUser(@PathVariable Long userId) {
        return trainingProvider.findTrainingsByUserId(userId).stream()
                .map(trainingMapper::toDto)
                .toList();
    }
}