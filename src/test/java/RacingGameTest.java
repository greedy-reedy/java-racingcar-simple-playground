import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void whenRacingGame_thenReturnWinner() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A"));
        cars.add(new Car("B"));
        cars.add(new Car("C"));
        cars.add(new Car("D"));
        cars.add(new Car("E"));

        RacingGame game = new RacingGame(cars);
        game.race(10);

        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getPosition()));
        game.getWinners().forEach(car -> System.out.println(car.getName()));

        assertThat(game.getWinners()).isNotEmpty();
        assertThat(game.getWinners().size()).isLessThanOrEqualTo(cars.size());
    }
}
