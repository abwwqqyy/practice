package QW;

import java.util.HashMap;
import java.util.Map;

class TrieNode1{
    public Map<Character, TrieNode1> children;
    public boolean isWord;
    public TrieNode1(){
        children = new HashMap<>();
        isWord = false;
    }
}
public class LC211DesignAddAndSearchWordsDataStructure {
    private TrieNode1 trie;
    public LC211DesignAddAndSearchWordsDataStructure() {
        trie = new TrieNode1();
    }

    public void addWord(String word) {
        TrieNode1 root = trie;
        for(char c : word.toCharArray()){
            if(!root.children.containsKey(c)){
                root.children.put(c, new TrieNode1());
            }
            root = root.children.get(c);
        }
        root.isWord = true;
    }

    private boolean lookUp(String word, TrieNode1 root) {
        for(int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            if(!root.children.containsKey(cur)){
                if(cur == '.'){
                    for(char c : root.children.keySet()){
                        TrieNode1 next = root.children.get(c);
                        if(lookUp(word.substring(i + 1), next)){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                root = root.children.get(cur);
            }
        }

        return root.isWord;
    }

    public boolean search(String word) {
        return lookUp(word, trie);
    }
}
