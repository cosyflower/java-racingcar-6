package refactor.view;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class InputView {
    private final Supplier<String> inputResolver;
    private final Consumer<String> outputResolver;

    public InputView(Supplier<String> inputResolver, Consumer<String> outputResolver) {
        this.inputResolver = inputResolver;
        this.outputResolver = outputResolver;
    }

    public void print(String message) {
        outputResolver.accept(message);
    }
}
