package sort;

import java.util.*;

public class InsertionSort {

    // 该算法类无需也不允许产生任何实例
    private InsertionSort() {}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 0; i < n; i ++) {

//            // 写法1
//            for(int j = i; j > 0; j -- )
//                if (arr[j].compareTo(arr[j-1]) < 0)
//                    swap(arr, j, j-1);
//                else
//                    break;
//
//            // 写法2：插入排序是可以提前结束内层循环的
//            for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--)
//                swap(arr, j, j-1);

            // 写法3
            Comparable e = arr[i];
            // j保存元素e应该插入的位置
            int j = i;
            for(; j > 0 && arr[j].compareTo(arr[j-1]) > 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;


        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(n, 100);

        SortTestHelper.testSort("sort.InsertionSort", arr);
        SortTestHelper.testSort("sort.SelectionSort", arr);
    }
}
