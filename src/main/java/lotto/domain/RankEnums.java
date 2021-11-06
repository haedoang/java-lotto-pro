package lotto.domain;

import lotto.common.Constants;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.MathUtil.calculateYield;

/**
 * packageName : lotto.domain
 * fileName : RankEnums
 * author : haedoang
 * date : 2021/11/06
 * description :
 */
public class RankEnums {
    private final List<RankEnum> rankEnums;

    public RankEnums(List<RankEnum> rankEnums) {
        this.rankEnums = new ArrayList(rankEnums);
    }


    public long totalRewards() {
        return this.rankEnums.stream().filter(rankEnum -> !rankEnum.equals(RankEnum.MISS))
                .mapToInt(rankEnum -> rankEnum.getWinningMoney()).sum();
    }

    public int countPlace(RankEnum rankEnum) {
        return (int) this.rankEnums.stream().filter(rank -> rank.equals(rankEnum)).count();
    }

    public double earningRatio() {
        return calculateYield(this.totalRewards(), rankEnums.size() * PurchasePrice.LOTTO_PRICE);
    }

    public void print() {
        ResultView.print(Constants.MSG_OUTPUT_LOTTO_RESULT);
        ResultView.print(Constants.MSG_OUTPUT_LINE_SEPARATOR);
        ResultView.print(getPlaceMessage(RankEnum.FIFTH));
        ResultView.print(getPlaceMessage(RankEnum.FOURTH));
        ResultView.print(getPlaceMessage(RankEnum.THIRD));
        ResultView.print(getPlaceMessage(RankEnum.SECOND));
        ResultView.print(getPlaceMessage(RankEnum.FIRST));
        ResultView.print(Constants.MSG_OUTPUT_YIELD_PREFIX + this.earningRatio() + Constants.MSG_OUTPUT_YIELD_SUFFIX);
    }

    private String getPlaceMessage(RankEnum rankEnum) {
        return new StringBuilder()
                .append(rankEnum.getCountOfMatch())
                .append(rankEnum.equals(RankEnum.SECOND) ? Constants.MSG_OUTPUT_PLACE_PREFIX_BONUS : Constants.MSG_OUTPUT_PLACE_PREFIX)
                .append(rankEnum.getWinningMoney()).append(Constants.MSG_OUTPUT_PLACE_SUFFIX).append(this.countPlace(rankEnum)).append(Constants.MSG_OUTPUT_SUFFIX).toString();
    }

}
