package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * packageName : study
 * fileName : StringTest
 * author : haedoang
 * date : 2022/01/12
 * description :
 */
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

    @Test
    @DisplayName("String 클래스의 substring은 문자열을 자를 수 있다.")
    public void substringTest() {
        // given
        String given = "(1,2)";

        // when
        final String actual = given.substring(given.indexOf("(") + 1, given.indexOf(")"));

        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스의 charAt() 메소드는 특정 위치의 문자를 반환한다.")
    public void charAtTest() {
        // given
        String given = "abc";

        // then
        assertAll(
                () -> assertThat(given.charAt(0)).isEqualTo('a' ),
                () -> assertThat(given.charAt(1)).isEqualTo('b' ),
                () -> assertThat(given.charAt(2)).isEqualTo('c' )
        );
    }

    @Test
    @DisplayName("String 클래스의 charAt() 메소드는 위치 값을 벗어나면 예외를 반환한다.")
    public void charAtException() {
        // given
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(Integer.MAX_VALUE)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
