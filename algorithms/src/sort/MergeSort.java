package sort;

import java.util.*;

public class MergeSort {

    private MergeSort() {}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归实现归并排序，对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        // merge sort 无优化版本
//        if (l >= r)
//            return;

        // 优化1: 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid =  l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化2: 对于arr[mid] <= arr[mid+1]的情况，不进行merge
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 开辟空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 双游针开始归并排序
        // 初始化，i指向左半部分的起始索引l; j指向右半部分起始索引mid+1
        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++) {
            if (i > mid) {
                // 左游针索引合法边界，左游针到底
                arr[k] = aux[j - l];
                j ++;
            } else if (j > r) {
                // 右游针索引合法边界，右游针到底
                arr[k] = aux[i - l];
                i ++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                // 左游针位置元素 < 右游针位置元素
                arr[k] = aux[i - l];
                i ++;
            } else {
                // 左游针位置元素 >= 右游针位置元素，稳定排序
                arr[k] = aux[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOfRange(arr1, 0, arr1.length);
        SortTestHelper.testSort("sort.InsertionSort", arr1);
        SortTestHelper.testSort("sort.MergeSort", arr2);
    }
}
