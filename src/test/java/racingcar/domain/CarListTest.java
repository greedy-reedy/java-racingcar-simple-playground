package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarListTest {

    @Test
    @DisplayName("우승자가 1명인 경우 해당 자동차를 반환한다.")
    public void findWinner_singleWinner() {
        Car car1 = new Car("자동차1", new FixedNumberGenerator(0));
        Car car2 = new Car("자동차2", new FixedNumberGenerator(0));
        car1.move();
        car1.move();
        car2.move();

        CarList carList = new CarList(List.of(car1, car2));
        List<Car> winners = new Winners(carList).getWinners();

        assertEquals(1, winners.size());
        assertEquals("자동차1", winners.get(0).getName());
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우 모두 반환한다.")
    public void findWinner_multipleWinners() {
        Car car1 = new Car("자동차1", new FixedNumberGenerator(0));
        Car car2 = new Car("자동차2", new FixedNumberGenerator(0));
        Car car3 = new Car("자동차3", new FixedNumberGenerator(0));
        car1.move();
        car2.move();

        CarList carList = new CarList(List.of(car1, car2, car3));
        List<Car> winners = new Winners(carList).getWinners();

        assertEquals(2, winners.size());
    }

    @Test
    @DisplayName("playRoundAllCar() 호출 시 모든 자동차가 이동한다.")
    public void playRoundAllCar_allCarsMove() {
        Car car1 = new Car("자동차1", new FixedNumberGenerator(4));
        Car car2 = new Car("자동차2", new FixedNumberGenerator(4));

        CarList carList = new CarList(List.of(car1, car2));
        carList.playRoundAllCar();

        List<Car> cars = carList.getCarList();
        assertEquals(1, cars.get(0).getPosition());
        assertEquals(1, cars.get(1).getPosition());
    }
}
