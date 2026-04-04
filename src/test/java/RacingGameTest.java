import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void winner_is_the_car_that_went_the_farthest(){
        List<Car> cars = new ArrayList<>();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        cars.add(carA);
        cars.add(carB);
        cars.add(carC);

        carA.move(4);
        carB.move(3);
        carC.move(3);

        RacingGame racingGame = new RacingGame(cars);
        List<Car> winners = racingGame.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("A");
    }

    @Test
    public void can_have_multiple_winners() {
        List<Car> cars = new ArrayList<>();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        cars.add(carA);
        cars.add(carB);
        cars.add(carC);

        carA.move(4);
        carB.move(4);
        carC.move(3);

        RacingGame racingGame = new RacingGame(cars);
        List<Car> winners = racingGame.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("A", "B");
    }
}
