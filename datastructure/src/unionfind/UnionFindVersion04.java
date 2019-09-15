package unionfind;

public class UnionFindVersion04 extends UnionFindVersion02 {

    private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFindVersion04(int size) {
        super(size);
        parent = new int[size];
        rank = new int[size];

        for(int i = 0; i < size; i ++) {
            parent[i] = i;
            rank[i] = 1;
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

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] ++;
        }
    }
}
