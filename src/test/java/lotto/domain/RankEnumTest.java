package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : RankEnumTest
 * author : haedoang
 * date : 2021/11/06
 * description : 랭크Enum Test
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class RankEnumTest {

    @Test
    @DisplayName("enum을 활용한 로또 당첨 개수 구하기")
    public void T1_countOfMatch() {
        //THEN
        assertThat(RankEnum.FIRST.getCountOfMatch()).isEqualTo(6);
        assertThat(RankEnum.SECOND.getCountOfMatch()).isEqualTo(RankEnum.THIRD.getCountOfMatch());
    }

    @Test
    @DisplayName("enum을 활용한 로또 당첨 금액 구하기")
    public void T2_getWinningMoney() {
        //THEN
        assertThat(RankEnum.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    }
}
