package refactor.exceptionHandler;

import java.util.function.Supplier;
import refactor.exception.RacingCarException;

public class ExceptionHandler {
    public static <T> T retryHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (RacingCarException e) {
            System.out.println(e.getMessage());
            return retryHandler(supplier);
        }
    }
}
