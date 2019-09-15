package unionfind;

public class UnionFindVersion03 extends UnionFindVersion02 {

    private int[] sz; // sz[i]表示以i为根的集合中的元素个数

    public UnionFindVersion03(int size) {
        super(size);
        parent = new int[size];
        sz = new int[size];

        for(int i = 0; i < size; i ++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    // 合并元素p和元素q所属的集合
    // O(h)的时间复杂度，其中h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = super.find(p);
        int qRoot = super.find(q);

        if (pRoot == qRoot)
            return;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
