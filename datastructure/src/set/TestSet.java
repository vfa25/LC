package set;

import java.util.ArrayList;

public class TestSet {
    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word: words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }
    public static void main(String[] args) {
        String filename = "src/pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + "s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedList Set: " + time2 + "s");

        System.out.println();

        AVLSet<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVL Set: " + time3 + "s");

//        System.out.println("Pride and Prejudice");
//
//        ArrayList<String> words = new ArrayList<>();
//        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
//
//            BSTSet<String> set = new BSTSet<>();
//            for (String word: words)
//                set.add(word);
//            System.out.println("Total different words: " + set.getSize());
//        }

//        System.out.println("Pride and Prejudice");
//
//        ArrayList<String> words = new ArrayList<>();
//        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
//
//            LinkedListSet<String> set = new LinkedListSet<>();
//            for (String word: words)
//                set.add(word);
//            System.out.println("Total different words: " + set.getSize());
//        }
    }
}
