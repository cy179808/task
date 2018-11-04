import java.util.*;
public class 作业1{
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {3,1,4,1,5,9,2,6};

        showReversedArray(array1);
        showReversedArray(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    /*
     * Reverse an array and print it in the standard output
     * @param a the input array
     */
    public static void showReversedArray(int[] a) {
        for(int i=0;i<(a.length)/2;i++)
        {
            int temp=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=temp;
        }
        // TODO
    }

}

