package lotto.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : PurchasePriceTest
 * author : haedoang
 * date : 2021-11-05
 * description : 구입금액 테스트 클래스
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PurchasePriceTest {
    private WinningLotto winningLotto;
    private Lotto firstPlaceLotto;
    private Lotto thirdPlaceLotto;

    @BeforeEach
    void setUp() {
        this.winningLotto = new WinningLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), new LottoNumber(7));
        this.firstPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.thirdPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(12)));
    }

    @Test
    @DisplayName("로또 구매 금액 테스트")
    public void T01_validPurchasePrice() {
        //GIVEN
        PurchasePrice price = new PurchasePrice(5000);
        //THEN
        assertThat(price).isEqualTo(new PurchasePrice(5000));
    }

    @ParameterizedTest(name = "유효하지 않은 금액 테스트 : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @ValueSource(ints = {0, 500, -5000, 350, 990})
    public void T2_invalid(int candidate) {
        //THEN
        assertThatThrownBy(() -> new PurchasePrice(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또를 구입할 금액이 부족합니다.");
    }

    @Test
    @DisplayName("로또 금액에 대한 로또구매개수 테스트")
    public void T03_validGetLottos() {
        //GIVEN
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto), new PurchasePrice(2000));
        //WHEN
        Ranks ranks = lottos.getResults(winningLotto);
        //THEN
        assertThat(ranks.countPlace(Rank.FIRST)).isEqualTo(1);
        assertThat(ranks.countPlace(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 금액에 맞게 로또구매개수 테스트 실패")
    public void T04_invalidGetLottos() {
        //THEN
        assertThatThrownBy(() -> new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto), new PurchasePrice(50000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매수량이 일치하지 않습니다.");
    }
}
