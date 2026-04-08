package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printNameInfo() {
        System.out.println("자동차의 이름을 입력해주세요: ");
    }

    public static void printWinners(List<Car> winners) {
        String winnersNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("우승자: " + winnersNames);
    }
}
