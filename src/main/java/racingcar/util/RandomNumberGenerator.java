package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 10;
    private final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(MIN_NUMBER, MAX_NUMBER);
    }
}
