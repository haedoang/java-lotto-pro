package lotto.domain;

import java.util.Objects;

/**
 * packageName : lotto.domain
 * fileName : Ball
 * author : haedoang
 * date : 2022/01/15
 * description :
 */
public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    private void validate(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
