package unionfind;

public class UnionFindVersion05 extends UnionFindVersion04 {

    private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFindVersion05(int size) {
        super(size);
        parent = new int[size];
        rank = new int[size];

        for(int i = 0; i < size; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
