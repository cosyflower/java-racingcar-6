package racingcar.system.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class StringToRacingCars {
    public static List<Car> convert(String input) {
        List<Car> registeredCars = new ArrayList<>();
        String[] splitedNames = input.split(",");

        Arrays.stream(splitedNames)
                .forEach(name -> registeredCars.add(new Car(name)));
        return registeredCars;
    }
}
