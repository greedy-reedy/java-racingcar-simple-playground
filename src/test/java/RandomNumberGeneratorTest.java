import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @Test
    void 랜덤_숫자가_0에서_9_사이로_생성된다() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);

        for (int i = 0; i < 100; i++) {
            int number = randomNumberGenerator.generate();
            assertThat(number).isBetween(0, 9);
        }
    }
}
