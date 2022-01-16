package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : PriceTest
 * author : haedoang
 * date : 2022/01/16
 * description :
 */
@DisplayName("금액 테스트")
public class PriceTest {
    @Test
    @DisplayName("금액 객체 생성하기")
    public void create() {
        // given
        Price price = Price.of(5_000);

        // then
        assertThat(price).isEqualTo(Price.of(5_000));
    }

    @DisplayName("유효하지 않은 금액 테스트")
    @ParameterizedTest(name = "candidate : {arguments}")
    @ValueSource(ints = {Integer.MIN_VALUE, -10, -1})
    public void validate(int candidate) {
        // then
        assertThatThrownBy(() -> Price.of(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 금액입니다.");
    }
}
