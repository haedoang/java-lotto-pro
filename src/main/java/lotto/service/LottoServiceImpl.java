package lotto.service;

import lotto.domain.*;
import lotto.ui.InputType;
import lotto.ui.InputView;


/**
 * packageName : lotto.service
 * fileName : LottoServiceImpl
 * author : haedoang
 * date : 2021/11/05
 * description :
 */
public class LottoServiceImpl implements LottoService {
    @Override
    public void start() {
        PurchasePrice price = (PurchasePrice) InputView.readLine(InputType.PURCHASE, null);
        price.print();
        Lottos lottos = price.buyLottery();
        lottos.print();
        WinningLotto winning = (WinningLotto) InputView.readLine(InputType.NUMBER, null);
        RankEnums rankEnums = lottos.getResults(winning);
        rankEnums.print();
    }


}

