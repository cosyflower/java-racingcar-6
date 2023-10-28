package racingcar.model;

import java.util.Objects;
import racingcar.exception.ErrorException;

public class Car {
    public static final int DISTANCE_INIT_VALUE = 0;
    public static final int CAR_NAME_STANDARD_LENGTH = 5;
    private final String carName;
    private int distance;

    public Car(String carName) {
        validateName(carName);
        this.carName = carName;
        this.distance = DISTANCE_INIT_VALUE;
    }

    public Car(String carName, int mockedDistance) {
        this.carName = carName;
        this.distance = mockedDistance;
    }

    public int compareTo(Car otherCar) {
        return this.distance - otherCar.distance;
    }

    public void move(int movingCriteria) {
        if (movingCriteria >= 4) {
            goForward();
        }
    }

    private void validateName(String carName) {
        isOverStandardLength(carName);
    }

    private void isOverStandardLength(String carName) {
        if (carName.length() > CAR_NAME_STANDARD_LENGTH) {
            throw new IllegalArgumentException(ErrorException.OVER_STANDARD_LENGTH.getErrorDescription());
        }
    }

    private void goForward() {
        distance++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", distance=" + distance +
                '}';
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

}
