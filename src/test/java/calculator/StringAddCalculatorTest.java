package calculator;

/**
 * packageName : calculator
 * fileName : StringAddCalculatorTest
 * author : haedoang
 * date : 2022/01/13
 * description :
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트 ")
public class StringAddCalculatorTest {

    @DisplayName("SpitAndSum()는 빈 문자열 또는 null 값일 경우 0을 반환한다")
    @ParameterizedTest(name = "candidate : {arguments}")
    @NullSource
    @EmptySource
    public void splitAndSum_null_또는_빈문자(String candidate) {
        int result = StringAddCalculator.splitAndSum(candidate);
        assertThat(result).isEqualTo(0)
                .isEqualTo(StringAddCalculator.DEFAULT_VALUE);
    }

    @Test
    @DisplayName("SplitAndSum()는 숫자하나가 올 경우 그 값을 숫자형으로 반환한다")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("SplitAndSum()는 쉼표 구분자를 기준으로 문자열을 더한다")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("SplitAndSum()는 : 구분자를 기준으로 문자열을 더한다")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("SplitAndSum()는 커스텀 구분자를 기준으로 문자열을 더한다")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("SplitAndSum()는 음수 값이 들어오는 경우 예외를 반환한다")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
