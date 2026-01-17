package pl.wsb.fitnesstracker.training.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class TrainingReportService {

    private final TrainingProvider trainingProvider;
    private final UserProvider userProvider;

    private static final Logger log = LoggerFactory.getLogger(TrainingReportService.class);

    public TrainingReportService(TrainingProvider trainingProvider, UserProvider userProvider) {
        this.trainingProvider = trainingProvider;
        this.userProvider = userProvider;
    }

    // @Scheduled(cron = "0 0 0 * * MON")
    @Scheduled(fixedRate = 30000)
    public void generateWeeklyReport() {
        log.info(">>> Rozpoczynam generowanie raportu tygodniowego w konsoli...");

        List<User> users = userProvider.findAllUsers();

        Date weekAgo = Date.from(LocalDateTime.now().minusWeeks(1)
                .atZone(ZoneId.systemDefault()).toInstant());

        for (User user : users) {
            List<Training> trainings = trainingProvider.findTrainingsByUserId(user.getId());

            List<Training> lastWeekTrainings = trainings.stream()
                    .filter(t -> t.getEndTime().after(weekAgo))
                    .toList();

            log.info("Użytkownik: {} {} (ID: {}). Ilość treningów w ostatnim tygodniu: {}",
                    user.getFirstName(), user.getLastName(), user.getId(), lastWeekTrainings.size());

            for (Training t : lastWeekTrainings) {
                log.info("\t -> Trening: {}, Dystans: {}, Data: {}", t.getActivityType(), t.getDistance(), t.getEndTime());
            }
        }

        log.info(">>> Zakończono generowanie raportu.");
    }
}