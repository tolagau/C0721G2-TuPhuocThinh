package _14_sort.exercise;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] list){
        int viTri, x;
        for (int i = 1; i < list.length-1;i++){
            x = list[i];
            viTri=i;
            while (viTri>0 && x < list[viTri-1]){
                list[viTri] = list[viTri-1];
                viTri--;
            }
            list[viTri]=x;
        }
        System.out.println(Arrays.toString(list));


    }

    public static void main(String[] args) {
        int[] array= {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        insertionSort(array);
    }
}
