package unionfind;

import java.util.Random;

public class TestUnionFind {
    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i < m; i ++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0; i < m; i ++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / Math.pow(10, 9);
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;

//        UnionFindVersion01 uf1 = new UnionFindVersion01(size);
//        System.out.println("UnionFindVersion01: " + testUF(uf1, m) + " s");
//
//        UnionFindVersion02 uf2 = new UnionFindVersion02(size);
//        System.out.println("UnionFindVersion02: " + testUF(uf2, m) + " s");

        UnionFindVersion03 uf3 = new UnionFindVersion03(size);
        System.out.println("UnionFindVersion03: " + testUF(uf3, m) + " s");

        UnionFindVersion04 uf4 = new UnionFindVersion04(size);
        System.out.println("UnionFindVersion04: " + testUF(uf4, m) + " s");

        UnionFindVersion05 uf5 = new UnionFindVersion05(size);
        System.out.println("UnionFindVersion05: " + testUF(uf5, m) + " s");

        UnionFindVersion06 uf6 = new UnionFindVersion06(size);
        System.out.println("UnionFindVersion06: " + testUF(uf6, m) + " s");
    }
}
