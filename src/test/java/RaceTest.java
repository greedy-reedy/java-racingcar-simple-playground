import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    void 가장_멀리_이동한_베스트_드라이버가_우승한다() {
        RacingCar car1 = new RacingCar("찬빈");
        RacingCar car2 = new RacingCar("석준");
        RacingCar car3 = new RacingCar("상희");
        RacingCar car4 = new RacingCar("혜림");

        car1.moveForward(4);
        car1.moveForward(4);
        car1.moveForward(4);
        car2.moveForward(3);
        car3.moveForward(2);
        car4.moveForward(1);
        Race race = new Race(new RacingCars(List.of(car1, car2, car3, car4)), new TestNumberGenerator(3));
        List<RacingCar> winners = race.findWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("찬빈");
    }

    @Test
    void 공동_우승도_가능하다() {
        RacingCar car1 = new RacingCar("찬빈");
        RacingCar car2 = new RacingCar("석준");
        RacingCar car3 = new RacingCar("상희");
        RacingCar car4 = new RacingCar("혜림");
        RacingCar car5 = new RacingCar("지우");

        car1.moveForward(4);
        car2.moveForward(3);
        car3.moveForward(2);
        car4.moveForward(1);
        car5.moveForward(4);
        Race race = new Race(new RacingCars(List.of(car1, car2, car3, car4, car5)), new TestNumberGenerator(3));
        List<RacingCar> winners = race.findWinners();

        assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    void 숫자가_4이상이면_모든_차가_전진한다() {
        RacingCar car1 = new RacingCar("찬빈");
        RacingCar car2 = new RacingCar("석준");
        Race race = new Race(new RacingCars(List.of(car1, car2)), new TestNumberGenerator(4));

        race.play(3);

        assertThat(car1.getPosition()).isEqualTo(3);
        assertThat(car2.getPosition()).isEqualTo(3);
    }

    @Test
    void 숫자가_4미만이면_모든_차가_전진하지_않는다() {
        RacingCar car1 = new RacingCar("상희");
        RacingCar car2 = new RacingCar("혜림");
        Race race = new Race(new RacingCars(List.of(car1, car2)), new TestNumberGenerator(3));

        race.play(3);

        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
    }
}
