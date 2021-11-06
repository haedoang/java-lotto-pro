package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : lotto.domain
 * fileName : WinningLotto
 * author : haedoang
 * date : 2021/11/06
 * description :
 */
public class WinningLotto {
    public static final int BALL_CNT = 6;

    private final List<LottoNumber> lottoNumberList;
    private final LottoNumber bonus;

    public WinningLotto(List<LottoNumber> lottoNumberList, LottoNumber bonus) {
        if (lottoNumberList == null || bonus == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (lottoNumberList.size() != BALL_CNT) throw new IllegalArgumentException("볼 개수가 일치하지 않습니다.");
        if (isDuplicate(lottoNumberList, bonus)) throw new IllegalArgumentException("중복된 볼을 가질 수 없습니다.");
        this.lottoNumberList = new ArrayList<>(lottoNumberList);
        this.bonus = bonus;
    }

    public boolean has(LottoNumber number) {
        return this.lottoNumberList.contains(number);
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumberList, LottoNumber bonus) {
        return lottoNumberList.stream().distinct().count() != Lotto.BALL_CNT || lottoNumberList.contains(bonus);
    }

    public boolean isBonus(LottoNumber lottoNumber) {
        return bonus.equals(lottoNumber);
    }
}
