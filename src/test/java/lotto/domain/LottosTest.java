package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : LottosTest
 * author : haedoang
 * date : 2021-11-05
 * description : 로또 리스트 테스트
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LottosTest {
    Lotto winning;
    Lotto firstPlaceLotto;
    Lotto secondPlaceLotto;
    Lotto thirdPlaceLotto;
    WinningLotto winningLotto;
    @BeforeEach
    void setUp() {
        this.winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.winningLotto = new WinningLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),new LottoNumber(7));
        this.firstPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.secondPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
        this.thirdPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(10), new LottoNumber(12)));
    }

    @Test
    @DisplayName("로또리스트에서 결과 구하기")
    public void T1_lottos() {
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto));
        Ranks ranks = lottos.getResults(winning);
        RankEnums rankEnums = lottos.getResults(winningLotto);

        assertThat(ranks.countPlace(new Rank(6))).isEqualTo(1);
        assertThat(ranks.countPlace(new Rank(2))).isEqualTo(0);
    }

}
