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

        carA.move();

        RacingGame racingGame = new RacingGame(cars, null);
        List<Car> winners = racingGame.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(carA);
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

        carA.move();
        carB.move();

        RacingGame racingGame = new RacingGame(cars,null);
        List<Car> winners = racingGame.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder(carA,carB);
    }

    @Test
    public void cars_moves_when_randomValues_is_4_or_more(){
        Car carA = new Car("A");
        Car carB = new Car("B");
        List<Car> cars = new ArrayList<>();

        cars.add(carA);
        cars.add(carB);

        RacingGame racingGame = new RacingGame(cars,()->4);
        racingGame.race(1);

        assertThat(carA.getPosition()).isEqualTo(1);
        assertThat(carB.getPosition()).isEqualTo(1);
    }

    @Test
    public void cars_stop_when_randomValues_is_3_or_less(){
        Car carA = new Car("A");
        Car carB = new Car("B");
        List<Car> cars = new ArrayList<>();

        cars.add(carA);
        cars.add(carB);

        RacingGame racingGame = new RacingGame(cars,()->3);
        racingGame.race(1);

        assertThat(carA.getPosition()).isEqualTo(0);
        assertThat(carB.getPosition()).isEqualTo(0);
    }
}
