import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void if_car_moves_position_increases() {
        Car car = new Car("A");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void initial_position_is_zero() {
        Car car = new Car("A");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
