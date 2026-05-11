import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @Test
    void 랜덤_숫자가_4_이상이면_레이싱카가_전진할수_있다() {
        RacingCar car = new RacingCar("상희");

        assertThat(car.canMove(4)).isTrue();
    }

    @Test
    void 랜덤_숫자가_4보다_작으면_레이싱카가_전진할수_없다() {
        RacingCar car = new RacingCar("혜림");

        assertThat(car.canMove(3)).isFalse();
    }

    @Test
    void 랜덤_숫자가_4_이상이면_레이싱카가_전진한다() {
        RacingCar car = new RacingCar("상희");
        car.moveForward(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자가_4보다_작으면_레이싱카가_멈춘다() {
        RacingCar car = new RacingCar("혜림");
        car.moveForward(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
