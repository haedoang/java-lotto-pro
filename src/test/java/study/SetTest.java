package study;

/**
 * packageName : study
 * fileName : SetTest
 * author : haedoang
 * date : 2022-01-13
 * description :
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


public class SetTest {

    @Test
    @DisplayName("Set 클래스의 size() 메소드는 Set 오브젝트의 크기를 확인할 수 있다.")
    public void getSize() {
        // given
        Set<Integer> numberSet = new HashSet<>(newArrayList(1, 2, 3, 4, 5, 5, 5, 5, 5, 5));

        // then
        assertThat(numberSet).hasSize(5);
    }

    @DisplayName("Set 클래스의 contains() 메소드로 값의 존재 여부를 확인할 수 있다.")
    @ParameterizedTest(name = "candidate : {arguments}")
    @ValueSource(ints = {1, 2, 3, 4})
    public void containsTest(int candidate) {
        // given
        Set<Integer> numberSet = new HashSet<>(newArrayList(1, 2, 3, 4));

        // then
        assertThat(numberSet.contains(candidate)).isTrue();
    }
}
