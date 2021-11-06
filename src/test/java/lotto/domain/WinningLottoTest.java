package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : WinningLottoTest
 * author : haedoang
 * date : 2021/11/06
 * description :
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class WinningLottoTest {
    private List<LottoNumber> lottoNumberList;
    private int bonusNumber = 7;
    private Lotto lottoPlace1;
    private Lotto lottoPlace2;
    private Lotto lottoPlace3;
    private Lotto lottoPlace4;
    private Lotto lottoPlace5;
    private Lotto bankruptcy;

    @BeforeEach
    void setUp() {
        this.lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        this.lottoPlace1 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.lottoPlace2 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(bonusNumber)));
        this.lottoPlace3 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(9)));
        this.lottoPlace4 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(8), new LottoNumber(9)));
        this.lottoPlace5 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)));
        this.bankruptcy = new Lotto(Arrays.asList(new LottoNumber(31), new LottoNumber(24), new LottoNumber(23), new LottoNumber(19), new LottoNumber(8), new LottoNumber(11)));
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    public void T1_firstPlace() {
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(this.bonusNumber));
        RankEnum rankEnum = lottoPlace1.getRank(winning);
        assertThat(rankEnum).isEqualTo(RankEnum.valueOf(6, false));
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    public void T2_secondPlace() {
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(bonusNumber));
        RankEnum rankEnum = lottoPlace2.getRank(winning);
        assertThat(rankEnum).isEqualTo(RankEnum.valueOf(5, true));
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    public void T3_thirdPlace() {
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(bonusNumber));
        RankEnum rankEnum = lottoPlace3.getRank(winning);
        assertThat(rankEnum).isEqualTo(RankEnum.valueOf(5, false));
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    public void T4_fourthPlace() {
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(bonusNumber));
        RankEnum rankEnum = lottoPlace4.getRank(winning);
        assertThat(rankEnum).isEqualTo(RankEnum.valueOf(4, true));
    }


    @Test
    @DisplayName("5등 당첨 테스트")
    public void T5_fifthPlace() {
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(bonusNumber));
        RankEnum rankEnum = lottoPlace5.getRank(winning);
        assertThat(rankEnum).isEqualTo(RankEnum.valueOf(3, true));
    }

    @Test
    @DisplayName("꽝 테스트 ")
    public void T6_bankruptcy() {
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(bonusNumber));
        RankEnum rankEnum = bankruptcy.getRank(winning);
        assertThat(rankEnum).isEqualTo(RankEnum.valueOf(2, true));
    }


    @Test
    @DisplayName("중복된 번호 체크하기")
    public void T7() {
        int duplicateNumber = 1;
        assertThatThrownBy(() -> new WinningLotto(lottoNumberList, new LottoNumber(duplicateNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 볼을 가질 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호 있는지 조회")
    public void T3_bonusNumberTest() {
        int isNotBonusNumber = 9;
        WinningLotto winning = new WinningLotto(lottoNumberList, new LottoNumber(bonusNumber));
        assertThat(winning.isBonus(new LottoNumber(bonusNumber))).isTrue();
        assertThat(winning.isBonus(new LottoNumber(isNotBonusNumber))).isFalse();
    }

}
