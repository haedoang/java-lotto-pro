package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : study
 * fileName : StringTest
 * author : haedoang
 * date : 2022/01/12
 * description :
 */

//- [ ] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
// - [ ] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
public class StringTest {
    @Test
    @DisplayName("String 클래스의 split은 문자열을 separator를 기준으로 분리할 수 있다.")
    public void splitTest() {
        // given
        String given = "1,2";
        String separator = ",";

        // when
        final String[] actual = given.split(separator);

        // then
        assertThat(actual).hasSize(2);
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 클래스의 split은 separator 이후 값이 없을 경우 그 값은 포함되지 않는다.")
    public void splitNotExist() {
        // given
        String given = "1,";
        String separator = ",";

        // when
        final String[] actual = given.split(separator);

        // then
        assertThat(actual).hasSize(1);
        assertThat(actual).contains("1");
    }
}
