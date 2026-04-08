package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Winners;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public void run() {
        int numberOfCars = InputView.inputNumberOfCars();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Car> inputCarList = new ArrayList<>();
        inputAllCarName(numberOfCars, inputCarList, randomNumberGenerator);
        int totalRound = InputView.inputRoundNumber();

        CarList carList = new CarList(inputCarList);

        playRace(carList, totalRound);

        Winners winners = new Winners(carList);

        List<Car> winnerCars = winners.getWinners();
        OutputView.printWinners(winnerCars);
    }

    private void inputAllCarName(int numberOfCars, List<Car> inputCarList, RandomNumberGenerator randomNumberGenerator) {
        OutputView.printNameInfo();
        for (int i = 0; i < numberOfCars; i++) {
            String name = InputView.inputCarName();
            inputCarList.add(new Car(name, randomNumberGenerator));
        }
    }

    private void playRace(CarList carList, int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            carList.playRoundAllCar();
        }
    }
}
