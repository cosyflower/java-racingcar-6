package racingcar.controller;

import java.util.Map;
import racingcar.system.converter.StringToRound;
import racingcar.view.inputview.InputView;
import racingcar.view.outputview.OutputView;

public class RegisterRoundController extends AbstractController {
    private final OutputView outputView;
    private final InputView inputView;

    public RegisterRoundController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        outputView.print(model);

        model.put("round", StringToRound.convertStringToRound((String) inputView.input(model)));
    }

}
