package QW;

import java.util.HashMap;
import java.util.Map;
class TrieNode3{
    private int count;
    private TrieNode3[] children;
    public TrieNode3(){
        count = 0;
        children = new TrieNode3[26];
    }
    public TrieNode3 get(char c){
        if(children[c - 'a'] == null){
            children[c - 'a'] = new TrieNode3();
            count++;
        }
        return children[c - 'a'];
    }
    public int getCount(){
        return count;
    }
}
public class LC820ShortEncodingOfWords {

    public static int minimumLengthEncoding(String[] words) {
        TrieNode3 trie = new TrieNode3();
        Map<TrieNode3, Integer> dict = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            TrieNode3 cur = trie;
            for(int j = words[i].length() - 1; j >=0; j--){ // put reversely as prefix
                cur = cur.get(words[i].charAt(j));
            }
            dict.put(cur, i);
        }
        int res = 0;
        for(TrieNode3 node : dict.keySet()){
            if(node.getCount() == 0){ // is leaf
                res += words[dict.get(node)].length() + 1;
            }
        }
        return res;
    }
}
// time O(avgWordLen*n) space O(avgWordLen*n)
