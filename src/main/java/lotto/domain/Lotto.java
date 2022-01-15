package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * packageName : lotto.domain
 * fileName : Lotto
 * author : haedoang
 * date : 2022/01/15
 * description :
 */
public class Lotto {
    public static final int BALL_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumberList) {
        validate(lottoNumberList);
        this.lottoNumbers = new ArrayList(lottoNumberList);
    }

    public static Lotto of(List<LottoNumber> lottoNumberList) {
        return new Lotto(lottoNumberList);
    }

    private void validate(List<LottoNumber> lottoNumberList) {
        if (lottoNumberList.size() != BALL_COUNT) {
            throw new IllegalArgumentException("볼 개수가 유효하지 않습니다.");
        }
        if (hasDuplicate(lottoNumberList)) {
            throw new IllegalArgumentException("중복된 볼이 존재합니다.");
        }
    }

    private boolean hasDuplicate(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.size() > new HashSet<>(lottoNumberList).size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
