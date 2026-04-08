package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public void playRoundAllCar() {
        for (Car car : carList) {
            car.playRound();
        }
    }

    public List<Car> getCarList() {
        return List.copyOf(carList);
    }
}
