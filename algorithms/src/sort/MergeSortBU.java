package sort;

import java.util.Arrays;

// 自底向上的迭代方法实现归并排序
// Merge Sort BU 也是O(nlogn)复杂度的算法
// 注意：以循环层数来判断算法的复杂度 并非总是有效的，Merge Sort BU 就是个反例
public class MergeSortBU {

    private MergeSortBU() {}

    // 迭代实现归并排序
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 外层循环：对进行merge的元素个数进行遍历。每次遍历变量 sz 将乘等于2，表示每轮归并，包含的元素个数倍增
        for (int sz = 1; sz < n; sz *= 2) {
            // 内层循环：变量i 表示每轮归并，元素的起始位置；循环条件i + sz < n表示有效归并
            for (int i = 0; i < n - sz; i += sz+sz) {
                // 对 arr[i...u+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
            }
        }
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 开辟空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 双游针开始归并排序
        // 初始化，i指向左半部分的起始索引l; j指向右半部分起始索引mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
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
        SortTestHelper.testSort("sort.MergeSortBU", arr1);
        SortTestHelper.testSort("sort.MergeSort", arr2);
    }
}
