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
        System.out.println(type.isPurchase() ? Constants.MSG_INPUT_PURCHASE_PRICE :
                type.isNumber() ? Constants.MSG_INPUT_LAST_WINNING_NUMBERS :
                        type.isBonus() ? Constants.MSG_INPUT_BONUMS_NUMBER : "");
        try {
            String input = scanner.nextLine();
            if (type.isPurchase()) return new PurchasePrice(input);
            if (type.isNumber()) return readLine(InputType.BONUS, input);
            if (type.isBonus()) return new WinningLotto(memorizedInput, new LottoNumber(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLine(type, memorizedInput);
        }
        return null;
    }
}
