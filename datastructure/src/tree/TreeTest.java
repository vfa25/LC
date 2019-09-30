package tree;

import map.Map;
import map.BSTMap;
import set.FileOperation;

import java.util.ArrayList;

public class TreeTest {

    private static double testAVL(AVLTree<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
//            Collections.sort(words);

            System.out.println("Total words: " + words.size());

            for (String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            for (String word: words)
                map.contains(word);

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
//            System.out.println("is BST: " + map.isBST());
//            System.out.println("is Balanced: " + map.isBalanced());


//            for (String word: words) {
//                map.remove(word);
//                if (!map.isBST() || !map.isBalanced())
//                    throw new RuntimeException("Error");
//            }
//            System.out.println("Process exited.");
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }
    private static double testBST(Map<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
//            Collections.sort(words);

            System.out.println("Total words: " + words.size());

            for (String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            for (String word: words)
                map.contains(word);

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }

    private static double testRBTree(RedBlackTree<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
//            Collections.sort(words);

            System.out.println("Total words: " + words.size());

            for (String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            for (String word: words)
                map.contains(word);

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }

    public static void main(String[] args) {

        String filename = "src/pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testBST(bstMap, filename);
        System.out.println("BST: " + time1 + "s");

        System.out.println();

        AVLTree<String, Integer> avlTree = new AVLTree<>();
        double time2 = testAVL(avlTree, filename);
        System.out.println("AVLTree: " + time2 + "s");

        System.out.println();

        RedBlackTree<String, Integer> rbTree = new RedBlackTree<>();
        double time3 = testRBTree(rbTree, filename);
        System.out.println("RedBlockTree: " + time3 + "s");
    }
}
