package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : BALL
 * author : haedoang
 * date : 2022/01/15
 * description :
 */
@DisplayName("로또 공 객체 테스트")
public class BallTest {
    @Test
    @DisplayName("로또 공 객체를 생성한다.")
    public void create() {
        // given
        Ball ball = Ball.of(45);

        // then
        assertThat(ball).isEqualTo(Ball.of(45));
    }

    @DisplayName("유효하지 않은 공 번호 테스트하기")
    @ParameterizedTest(name = "candidate : {arguments}")
    @ValueSource(ints = {Integer.MIN_VALUE, Integer.MAX_VALUE, Ball.MIN_VALUE - 1, Ball.MAX_VALUE + 1})
    public void illegalBallNumber(int candidate) {
        // then
        assertThatThrownBy(() -> Ball.of(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 번호가 아닙니다.");
    }
}
