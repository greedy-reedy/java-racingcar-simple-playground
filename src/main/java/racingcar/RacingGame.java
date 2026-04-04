package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int count) {
        for (int i = 0; i < count; i++) {
            tryMoveCars();
        }
    }
    public void tryMoveCars(){
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    public void moveIfPossible(Car car){
        int randomValue = (int) (Math.random() * 10);
        if (randomValue >= 4) {
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
