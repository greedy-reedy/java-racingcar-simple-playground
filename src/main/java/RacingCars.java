import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void moveForward(NumberGenerator numberGenerator) {
        for (RacingCar racingCar : this.racingCars){
            racingCar.moveForward(numberGenerator.generate());
        }
    }

    public List<RacingCar> findByPosition(int position) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == position)
                .toList();
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : this.racingCars) {
            maxPosition = Math.max(maxPosition, racingCar.getPosition());
        }
        return maxPosition;
    }
}
