package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printRoundResult() {
        System.out.println("실행 결과");
    }

    public static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnersNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnersNames + "가 최종 우승했습니다.");
    }
}
