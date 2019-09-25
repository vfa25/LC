package trie;

import java.util.TreeMap;
import java.util.Stack;

public class Trie {
    private class Node {
        public boolean isWord;
        // 已默认Character字符
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize() {
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询在Trie中是否有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    // 删除word，返回是否删除成功
    public boolean remove(String word) {
        // 将搜索沿途的结点放入栈中
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for(int i = 0; i < word.length(); i ++) {
            if (!stack.peek().next.containsKey(word.charAt(i)))
                return false;
            stack.push(stack.peek().next.get(word.charAt(i)));
        }

        if (!stack.peek().isWord)
            return false;

        // 将该结尾的isWord置空
        stack.peek().isWord = false;
        size --;

        // 如果单词最后一个字母的结点的next非空，
        // 说明trie还存储了其他以该单词为前缀的单词，直接返回
        if (stack.peek().next.size() > 0)
            return true;
        else
            stack.pop();

        // 自底向上删除
        for(int i = word.length() - 1; i >= 0; i --) {
            stack.peek().next.remove(word.charAt(i));
            // 如果一个结点的isWord为true，或者是其他单词的前缀，直接返回
            if (stack.peek().isWord || stack.peek().next.size() > 0)
                return true;
            stack.pop();
        }
        return true;
    }
}
