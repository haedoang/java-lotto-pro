package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * packageName : lotto.domain
 * fileName : LottoTest
 * author : haedoang
 * date : 2022/01/15
 * description :
 */
@DisplayName("로또 객체 테스트")
public class LottoTest {
    @Test
    @DisplayName("로또 객체를 생성한다.")
    public void create() {
        // given
        final List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );

        // when
        Lotto lotto = Lotto.of(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아닐 경우 예외를 발생한다.")
    public void illegalBallCount() {
        // given
        final List<LottoNumber> emptyBall = Arrays.asList();
        final List<LottoNumber> sevenBalls = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6),
                LottoNumber.of(7)
        );

        // then
        assertAll(
                () -> assertThatThrownBy(() -> Lotto.of(emptyBall)).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("볼 개수가 유효하지 않습니다."),
                () -> assertThatThrownBy(() -> Lotto.of(sevenBalls)).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("볼 개수가 유효하지 않습니다.")
        );
    }

    @Test
    @DisplayName("로또 번호가 존재하는 지 확인할 수 있다.")
    public void contains() {
        // given
        final List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );

        // when
        Lotto lotto = Lotto.of(lottoNumbers);

        // then
        assertThat(lotto.contains(LottoNumber.of(1))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(7))).isFalse();
    }
}
