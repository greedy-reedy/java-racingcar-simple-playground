import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void carGoTest() {
        Car car = new Car("A");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carStopTest() {
        Car car = new Car("B");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
