package lotto.domain;

import java.util.Objects;

/**
 * packageName : lotto.domain
 * fileName : Price
 * author : haedoang
 * date : 2022/01/16
 * description :
 */
public class Price {
    private static final int MIN_PRICE = 0;
    private final int price;

    private Price(int price) {
        validate(price);
        this.price = price;
    }

    public static Price of(int price) {
        return new Price(price);
    }

    private void validate(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 금액입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Price)) {
            return false;
        }
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
