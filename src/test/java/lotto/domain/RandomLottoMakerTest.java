package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : lotto.domain
 * fileName : RandomLottoMakerTest
 * author : haedoang
 * date : 2022/01/16
 * description :
 */
class RandomLottoMakerTest {

    @Test
    @DisplayName("자동 로또 생성기 구현")
    public void createLotto() {
        // given
        final Lotto firstLotto = RandomLottoMaker.create();
        final Lotto secondLotto = RandomLottoMaker.create();

        // then
        assertThat(firstLotto).isNotEqualTo(secondLotto).as("");
    }

}