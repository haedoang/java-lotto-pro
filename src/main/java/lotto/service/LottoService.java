package lotto.service;

import lotto.common.utils.StringUtil;
import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.Message;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : lotto.service
 * fileName : LottoServiceImpl
 * author : haedoang
 * date : 2021/11/05
 * description : 로또 게임 서비스
 */
public class LottoService {
    public void start() {
        PurchasePrice price = this.purchase();
        Lottos lottos = this.getLottos(price);
        lottos.print();
        Lotto winning = this.inputWinningNumber();
        WinningLotto lottoWithBonus = this.inputBonusNumber(winning);
        Ranks results = this.lottoResults(lottos, lottoWithBonus);
        results.print();
    }

    private PurchasePrice purchase() {
        try {
            ResultView.print(Message.PURCHASE.getMessage());
            return new PurchasePrice(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return purchase();
        }
    }

    private WinningLotto inputBonusNumber(Lotto winning) {
        try {
            ResultView.print(Message.BONUS.getMessage());
            String input = InputView.readLine();
            LottoNumber bonus = LottoNumber.valueOf(input);
            return new WinningLotto(winning, bonus);
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputBonusNumber(winning);
        }
    }


    private Lottos getLottos(PurchasePrice price) {
        int manualCount = this.inputManualLottoCount(price);
        List<Lotto> lottoList = this.createManualLottoList(manualCount);
        lottoList.addAll(price.buyLottoAuto(manualCount));
        return new Lottos(lottoList);
    }

    private List<Lotto> createManualLottoList(int manualCount) {
        List<Lotto> lottoList = new ArrayList<>();
        ResultView.print(Message.MANUAL_NUMBER.getMessage());
        for(int i = 0; i < manualCount; i++) {
            lottoList.add(this.inputManualLottoNumber());
        }
        return lottoList;
    }

    private Lotto inputManualLottoNumber() {
        try {
            return new Lotto(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputManualLottoNumber();
        }
    }

    private int inputManualLottoCount(PurchasePrice price) {
        try {
            ResultView.print(Message.MANUAL_COUNT.getMessage());
            int count = StringUtil.parseNumber(InputView.readLine());
            if(!price.isAbleToBuy(count)) throw new IllegalArgumentException("구매 가능한 수량을 초과하였습니다.");
            return count;
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputManualLottoCount(price);
        }
    }

    public Lotto inputWinningNumber() {
        try {
            ResultView.print(Message.NUMBER.getMessage());
            return new Lotto(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputWinningNumber();
        }
    }

    private Ranks lottoResults(Lottos lottos, WinningLotto lottoWithBonus) {
        return lottos.getResults(lottoWithBonus);
    }


}

