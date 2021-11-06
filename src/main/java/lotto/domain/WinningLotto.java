package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constants.NUMBER_SEPARATOR;

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

    public WinningLotto(String input, LottoNumber bonus) {
        if (input == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (input.isEmpty()) throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        String[] numbers = input.split(NUMBER_SEPARATOR);
        if (numbers.length != Lotto.BALL_CNT) throw new IllegalArgumentException("숫자 개수가 올바르지 않습니다.");
        if (!isLottoNumber(numbers)) throw new IllegalArgumentException("입력값이 올바르지 않습니다");
        this.lottoNumberList = new ArrayList<>(Arrays.stream(numbers).map(number -> new LottoNumber(Integer.parseInt(number.trim()))).collect(Collectors.toList()));
        this.bonus = bonus;
    }

    private boolean isLottoNumber(String[] numbers) {
        try {
            return Arrays.stream(numbers).allMatch(number -> Integer.parseInt(number.trim()) >= LottoNumber.MIN_NUMBER && Integer.parseInt(number.trim()) <= LottoNumber.MAX_NUMBER);
        } catch (NumberFormatException nfe) {
            return false;
        }
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
