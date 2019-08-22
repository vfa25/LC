package bstree;

import java.util.*;

// 在本例中，二分搜索树不包含重复元素
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    // 查询二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 查询以node为根的二分搜索树种是否包含元素e，递归算法
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的迭代实现前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 深度优先
    public void preOrderDFS() {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node right = null;
        while(cur != null || !stack.isEmpty()) {
            // 一直找到当前结点最左端的叶子结点
            while (cur != null) {
                System.out.println(cur.e);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // while循环：如果当前结点 cur 没有右结点 或 缓存的right结点是当前的右结点（即左右子树均已遍历）
            // 标记一下，再度cur = stack.pop()，即返回父结点
            while (cur.right == null || cur.right == right) {
                right = cur;
                if (stack.isEmpty()) {
                    return;
                }
                cur = stack.pop();
            }
            stack.push(cur);
            cur = cur.right;
        }
    }

    // 广度优先
    public void preOrderBFS() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    // 二分搜索树的迭代实现中序遍历
    public void inOrderNR() {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()) {
            // 一直找到当前结点最左端的叶子结点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.e);
            cur = cur.right;
        }
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 中序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    // 二分搜索树的迭代实现后序遍历
    public void postOrderNR() {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node right = null;
        while(cur != null || !stack.isEmpty()) {
            // 一直找到当前结点最左端的叶子结点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // 如果当前结点没有右结点 或 缓存的right结点是当前的右结点（左右子树均已遍历）才执行当前结点输出
            while (cur.right == null || cur.right == right) {
                System.out.println(cur.e);
                right = cur;
                if (stack.isEmpty()) {
                    return;
                }
                // 返回父级
                cur = stack.pop();
            }
            stack.push(cur);
            cur = cur.right;
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的结点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的结点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在的结点，返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小结点
    // 返回删除结点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在的结点，返回最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大结点
    // 返回删除结点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的结点
    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除以node为根的二分搜索树中值为e的结点，递归算法
    // 返回删除结点后的新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            } else {
                // 即左右子树都不为空的情况
                // 找到比待删除结点大的最小结点，即待删除结点右子树的最小结点
                // 用这个结点顶替待删除结点的位置
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
    }

    public E floor(E e) {
        if (root == null || e.compareTo(minimum()) < 0)
            return null;
        return floor(root, e).e;
    }

    private Node floor(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) == 0)
            return node;
        else if (e.compareTo(node.e) < 0)
            return floor(node.left, e);
        else {
            Node next = floor(node.right, e);
            if (next == null)
                return node;
            else {
                return next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {7, 4, 2, 3, 1, 5, 8 };
        for (int num: nums)
            bst.add(num);

//        ;
        System.out.println(bst.floor(6));

//        bst.preOrderDFS();
//        System.out.println();

//        bst.inOrder();
//        System.out.println();

//        System.out.println(bst);
//        Random random = new Random();
//
//        int n = 1000;
//
//        for (int i = 0; i < n; i ++)
//            bst.add(random.nextInt(1000));
//
//        ArrayList<Integer> nums = new ArrayList<>();
//        while (!bst.isEmpty())
//            nums.add(bst.removeMin());
//
//        System.out.println(nums);
//        for (int i = 1; i < nums.size(); i ++)
//            if (nums.get(i - 1) > nums.get(i))
//                throw new IllegalArgumentException("Error");
//        System.out.println("removeMin test completed");


    }
}
