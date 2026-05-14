package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Winners;
import racingcar.util.CarNameSeparator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public void run() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Car> inputCarList = new ArrayList<>();

        String rawCarNames = InputView.inputCarNames();
        String[] carNames = CarNameSeparator.separator(rawCarNames);

        inputAllCarName(inputCarList, carNames, randomNumberGenerator);
        int totalRound = InputView.inputRoundNumber();

        CarList carList = new CarList(inputCarList);

        OutputView.printRoundResult();
        playRace(carList, totalRound);

        Winners winners = new Winners(carList);

        List<Car> winnerCars = winners.getWinners();
        OutputView.printWinners(winnerCars);
    }

    private void inputAllCarName(List<Car> inputCarList, String[] carNames, RandomNumberGenerator randomNumberGenerator) {
        for (String carName : carNames) {
            inputCarList.add(new Car(carName, randomNumberGenerator));
        }
    }

    private void playRace(CarList carList, int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            carList.playRoundAllCar();
            for (Car car : carList.getCarList()) {
                OutputView.printCarPosition(car);
            }
            OutputView.printNewLine();
        }
    }
}
