import java.util.ArrayList;
import java.util.List;

public class Race {
    private final RacingCars racingCars;
    private final NumberGenerator numberGenerator;

    public Race(RacingCars racingCars, NumberGenerator numberGenerator) {
        this.racingCars = racingCars;
        this.numberGenerator = numberGenerator;
    }

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            racingCars.moveForward(numberGenerator);
        }
    }

    public List<RacingCar> findWinners() {
        int maxPosition = racingCars.findMaxPosition();
        return racingCars.findByPosition(maxPosition);
    }
}
