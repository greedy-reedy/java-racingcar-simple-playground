package racingcar.util;

public class CarNameSeparator {
    private static final String DELIMITER = ",";

    public static String[] separator(String rawCarNames) {
        return rawCarNames.split(DELIMITER);
    }
}
