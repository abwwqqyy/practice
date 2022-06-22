package QW;

import java.util.*;

public class LC127WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String w : wordList){
            wordSet.add(w);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        if(!wordSet.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return step;
                }
                // wordSet.remove(cur);
                for(int j = 0; j < endWord.length(); j++){
                    char substitute = cur.charAt(j);
                    for(int k = 0; k < 26; k++){
                        if(k == substitute - 'a') continue;
                        StringBuilder next = new StringBuilder(cur);
                        next.setCharAt(j, (char) (k + 'a'));
                        if(wordSet.contains(next.toString())){
                            q.offer(next.toString());
                            wordSet.remove(next.toString());
                            // System.out.println(next.toString() + " step: " + step);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(ladderLength("hit", "cog", wordList)); // 5
    }
}
// time O(n*avgWordLen^2) space O(n)
