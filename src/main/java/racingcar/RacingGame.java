package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private RandomValueGenerator randomValueGenerator;

    public RacingGame(List<Car> cars, RandomValueGenerator randomValueGenerator) {
        this.cars = cars;
        this.randomValueGenerator = randomValueGenerator;
    }

    public void race(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("경주 횟수는 1회 이상이여야 합니다.");
        }
        for (int i = 0; i < count; i++) {
            tryMoveCars();
        }
    }

    public void tryMoveCars() {
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    public void moveIfPossible(Car car) {
        if (randomValueGenerator.generate() >= 4) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }
}
