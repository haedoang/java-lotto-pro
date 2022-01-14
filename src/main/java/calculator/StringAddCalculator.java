package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * packageName : calculator
 * fileName : StringAddCalculator
 * author : haedoang
 * date : 2022-01-14
 * description :
 */
public class StringAddCalculator {
    public static final int DEFAULT_VALUE = 0;
    public static final List<String> DEFAULT_SEPARATORS = Arrays.asList(",", ":");
    public static final String CUSTOM_SEPARATOR_START = "//";
    public static final String CUSTOM_SEPARATOR_END = "\n";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return DEFAULT_VALUE;
        }

        if (str.length() == 1) {
            return parsePositiveNumber(str);
        }

        String[] split = split(str);
        return sum(split);
    }

    private static int sum(String[] split) {
        return Arrays.stream(split)
                .mapToInt(StringAddCalculator::parsePositiveNumber)
                .sum();
    }

    private static int parsePositiveNumber(String str) {
        int result = Integer.parseInt(str);
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }

    private static String[] split(String str) {
        if (hasCustomSeparator(str)) {
            String[] split = str.split(CUSTOM_SEPARATOR_END);
            String customSeparator = split[0].replace(CUSTOM_SEPARATOR_START, "");
            return split[1].split(customSeparator);
        }
        return str.split(createRegex());
    }

    private static String createRegex() {
        return String.join("|", DEFAULT_SEPARATORS);
    }

    private static boolean hasCustomSeparator(String str) {
        return str.contains(CUSTOM_SEPARATOR_START) && str.contains(CUSTOM_SEPARATOR_END);
    }
}
