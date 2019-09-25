package unionfind;

public class UnionFindVersion06 extends UnionFindVersion04 {

    private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFindVersion06(int size) {
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

        if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }
}
