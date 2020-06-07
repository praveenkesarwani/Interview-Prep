import java.io.*;
import java.util.*;

class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // convert list to hashset
        HashSet<String> wordSet = new HashSet<>();
        for (String s : wordList)
            wordSet.add(s);
        // if endword is not present in wordList return 0
        if (!wordSet.contains(endWord))
            return 0;
        return shortestChainLength(beginWord, endWord, wordSet);
    }
    //BFS Traversal
    public int shortestChainLength(String beginWord, String endWord, HashSet<String> wordSet) {
        int level = 0; // answer
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); // insert beginWord
        while (!queue.isEmpty()) {
            level++; // increment level
            int Qsize = queue.size();
            for (int i = 0; i < Qsize; i++) {
                char[] word = queue.peek().toCharArray(); // remove the front value and convert it to char Array
                queue.poll();
                for (int pos = 0; pos < word.length; pos++) {
                    char originalChar = word[pos]; // store the original character of array
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[pos] = c; // change the character from a to z
                        if (String.valueOf(word).equals(endWord)) // if this updated word is the endWord return level+1
                            return level + 1;
                        // if this word present in wordSet, remove it and add it to queue
                        if (wordSet.contains(String.valueOf(word))) {
                            wordSet.remove(String.valueOf(word));
                            queue.offer(String.valueOf(word));
                        } else
                            continue;
                    }
                    word[pos] = originalChar; // restore the word
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String beginWord = scanner.nextLine();
        String endWord = scanner.nextLine();

        int n = scanner.nextInt();
        List<String> wordList = new ArrayList<String>();

        for (int i = 0; i < n; ++i) {
            String word = scanner.next();
            wordList.add(word);
        }
        scanner.close();
        int result = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
