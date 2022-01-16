package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * packageName : lotto.domain
 * fileName : RandomLottoMaker
 * author : haedoang
 * date : 2022/01/16
 * description :
 */
public class RandomLottoMaker {
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private RandomLottoMaker() {
    }

    public static Lotto create() {
        shuffle();
        return Lotto.of(new ArrayList<>(lottoNumbers.subList(0, Lotto.BALL_COUNT)));
    }

    private static void shuffle() {
        Collections.shuffle(lottoNumbers);
    }
}
