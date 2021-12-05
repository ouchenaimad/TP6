package model;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    private RandomUtil() {
    }

    public static <T> T randomElement(List<T> elements, Random random) {
        return elements.get(random.nextInt(elements.size()));
    }

    public static <T> T randomElement(T[] elements, Random random) {
        return elements[(random.nextInt(elements.length))];
    }
}
