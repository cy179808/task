import java.util.*;

public class 作业2 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 4};
        int[] array2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 3, 9};
        int[] array3 = {1, 1, 1, 1};
        showNonDuplicateArray(array1);
        showNonDuplicateArray(array2);
        showNonDuplicateArray(array3);
    }

    public static void showNonDuplicateArray(int[] a) {
        List list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (!list.contains(a[i]))
                list.add(a[i]);
        }
        Object[] newarray = list.toArray();
        System.out.println(Arrays.toString(newarray));
    }
}