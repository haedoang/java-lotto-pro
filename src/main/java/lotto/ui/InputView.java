package lotto.ui;

import lotto.common.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;

import java.util.Scanner;

/**
 * packageName : lotto.ui
 * fileName : InputView
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class InputView {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static Object readLine(InputType type, String memorizedInput) {
        ResultView.print(type);
        try {
            String input = scanner.nextLine();
            if (type.isPurchase()) return new PurchasePrice(input);
            if (type.isNumber() && !Lotto.isLottoNumber(input.split(Constants.NUMBER_SEPARATOR)))
                throw new IllegalArgumentException("숫자가 올바르지 않습니다.");
            if (type.isNumber() && Lotto.isLottoNumber(input.split(Constants.NUMBER_SEPARATOR)))
                return readLine(InputType.BONUS, input);
            if (type.isBonus()) return new WinningLotto(memorizedInput, new LottoNumber(input));
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return readLine(type, memorizedInput);
        }
        return null;
    }
}
