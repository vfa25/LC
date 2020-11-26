package sort;

public class QuickSortThreeWays {

    private QuickSortThreeWays() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用，对arr[l...r]部分进行快速排序
    private static void sort(Comparable[] arr, int l, int r) {

        // merge sort 无优化版本
//        if (l >= r)
//            return;

        // 优化1: 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 优化2：随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, r, (int)(Math.random()*(r-l+1))+l);

        Comparable v = arr[r];

        int lt = l; // arr[l...lt] < v
        int gt = r; // arr[gt...r) > v
        int i = l; // 正在考察的元素，且arr[lt+1...i) == v

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i,gt-1);
                gt--;
                // 此时 i 无需自增，因为依然指向的是 未被处理的元素
            } else {
                i++;
            }
        }

        swap(arr, gt, r);

        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static public void main(String[] args) {
//        Comparable[] a = {4, 3, 4, 5, 6, 2, 1, 7};
//        QuickSortDealWithIdenticalKeys.sort(a);
//        for( int i = 0 ; i < a.length ; i ++ ){
//            System.out.print(a[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSort("sort.MergeSort", arr);
        SortTestHelper.testSort("sort.QuickSortDealWithIdenticalKeys", arr);
        SortTestHelper.testSort("sort.QuickSortThreeWays", arr);
    }
}
