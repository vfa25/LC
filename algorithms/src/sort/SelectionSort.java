package sort;

import java.util.*;

public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            // 寻找(i, n)区间内的最小元素
            int minIndex = i;
            for (int j = i + 1; j < n; j ++)
                // 使用compareTo方法比较两个Comparable对象的大小
                if( arr[j].compareTo(arr[minIndex]) < 0 )
                    minIndex = j;
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

//    public static void main(String[] args) {
//        Integer[] arr = {8, 6, 2, 3, 1, 5, 7, 4};
//        SelectionSort.sort(arr);
//        for( int i = 0 ; i < arr.length ; i ++ ){
//            System.out.print(arr[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试Double
//        Double[] b = {4.4, 3.3, 2.2, 1.1};
//        SelectionSort.sort(b);
//        for( int i = 0 ; i < b.length ; i ++ ){
//            System.out.print(b[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试String
//        String[] c = {"D", "C", "B", "A"};
//        SelectionSort.sort(c);
//        for( int i = 0 ; i < c.length ; i ++ ){
//            System.out.print(c[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);

//        SelectionSort.sort(arr);
        SortTestHelper.testSort("sort.SelectionSort", arr);
    }

}
