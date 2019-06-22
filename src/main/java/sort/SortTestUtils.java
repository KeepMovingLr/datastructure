package sort;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author enyi.lr
 * @version $Id: SortTestUtils.java, v 0.1 2019‐06‐19 12:53 PM enyi.lr Exp $$
 */
public class SortTestUtils {

    /**
     * @param length
     * @param rangeL inclusive
     * @param rangeR inclusive
     * @return [rangeL, rangeR]
     */
    public static Integer[] generateArray(int length, int rangeL, int rangeR) {
        Random random = new Random();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return array;
    }

    public static int[] generateIntArray(int length, int rangeL, int rangeR) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return array;
    }

    public static int[] copy(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void testSort(String sortName, int[] array) throws Exception {
        Class<?> aClass = Class.forName("sort.SortInt");
        Object instance = aClass.newInstance();
        long begin = System.currentTimeMillis();
        Method method = aClass.getDeclaredMethod(sortName, int[].class);

        method.setAccessible(true);
        method.invoke(instance, array);
        long end = System.currentTimeMillis();

        System.out.println("time cost:" + (end - begin) + "ms");

    }

    public static void main(String[] args) throws Exception {
        int[] array = SortTestUtils.generateIntArray(10, 1, 10);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        testSort("selectionSort", array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}