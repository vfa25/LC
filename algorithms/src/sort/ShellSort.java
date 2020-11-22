package sort;

public class ShellSort {

    private ShellSort() {}

    public static void sort(Comparable[] arr){

        int gap = arr.length;

        while (true) {
            gap /= 2; //增量每次减半
            for (int i = 0; i < gap; i ++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    // 这个循环里其实就是对 gap的倍数 这一分组，进行插入排序
                    Comparable temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k].compareTo(temp) > 0) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
            if (gap == 1)
                break;
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);

        SortTestHelper.testSort("sort.ShellSort", arr);
    }
}
