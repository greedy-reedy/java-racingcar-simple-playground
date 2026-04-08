package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("자동차를 생성하고 move 메서드를 통해 위치가 1 증가한다.")
    public void play_moveMethod() {
        Car car = new Car("테스트 자동차", new FixedNumberGenerator(0));
        car.move();

        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 기준치(4)보다 클 때 자동차가 움직이는지 확인한다.")
    public void playRace_overThreshold() {
        Car car = new Car("테스트 자동차", new FixedNumberGenerator(4));

        car.playRound();
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 기준치(4)보다 작을 때 자동차가 움직이지 않는지 확인한다.")
    public void playRace_underThreshold() {
        Car car = new Car("테스트 자동차", new FixedNumberGenerator(3));

        car.playRound();
        assertEquals(0, car.getPosition());
    }
}
