package tree;

import java.util.ArrayList;
import set.*;

public class TrieTest {
    private static double testSet(Set set, String filename) {
        ArrayList<String> words = new ArrayList<>();

        long startTime = System.nanoTime();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
            for (String word: words)
                set.add(word);
            for (String word: words)
                set.contains(word);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }
    private static double testTrie(Trie trie, String filename) {
        ArrayList<String> words = new ArrayList<>();

        long startTime = System.nanoTime();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
            for (String word: words)
                trie.add(word);
            for (String word: words)
                trie.contains(word);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }
    public static void main(String[] args) {
        String filename = "src/pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("Total different words: " + bstSet.getSize());
        System.out.println("BST Set: " + time1 + "s");

        System.out.println();

        Trie trie = new Trie();
        double time2 = testTrie(trie, filename);
        System.out.println("Total different words: " + trie.getSize());
        System.out.println("Trie: " + time2 + "s");
    }
}
