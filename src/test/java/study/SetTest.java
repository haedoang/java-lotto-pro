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
}
