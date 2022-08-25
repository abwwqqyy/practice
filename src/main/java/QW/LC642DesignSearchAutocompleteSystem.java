package QW;

import java.util.*;

public class LC642DesignSearchAutocompleteSystem {
    private class TN{
        TN[] children;
        boolean isEnd;
        public TN(){
            children = new TN[27];
            isEnd = false;
        }
    }

    StringBuilder curSentence;
    Map<String, Integer> sen;
    TN root;
    public LC642DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new TN();
        curSentence = new StringBuilder();
        sen = new HashMap<>();
        for(int i = 0; i < times.length; i++){
            sen.put(sentences[i], times[i]);
            add(sentences[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c == '#'){
            int count = sen.getOrDefault(curSentence.toString(), 0);
            sen.put(curSentence.toString(), count + 1);
            add(curSentence.toString());
            curSentence = new StringBuilder();
            // System.out.println(sen);
            return res;
        }
        curSentence.append(c);
        TN cur = search(curSentence.toString());
        if(cur == null) return res;
        // System.out.println(Arrays.toString(cur.children));
        dfs(cur, curSentence, res);
        // System.out.println(res);
        res = trimTo3(res);
        return res;
    }

    private void add(String str){
        TN cur = root;
        for(char c : str.toCharArray()){
            int ind = c - 'a';
            if(c == ' '){
                ind = 26;
            }
            if(cur.children[ind] == null){
                cur.children[ind] = new TN();
            }
            cur = cur.children[ind];
        }
        cur.isEnd = true;
    }

    private TN search(String str){
        TN cur = root;
        for(char c : str.toCharArray()){
            int ind = c - 'a';
            if(c == ' '){
                ind = 26;
            }
            if(cur.children[ind] == null){
                return null;
            }
            cur = cur.children[ind];
        }
        return cur;
    }

    private void dfs(TN cur, StringBuilder sb, List<String> res){
        if(cur == null) return;
        if(cur.isEnd){
            res.add(sb.toString());
        }
        for(int i = 0; i <= 26; i++){
            if(cur.children[i] == null) {
                continue;
            }
            char c = (char) (i + 'a');
            if(i == 26) c = ' ';
            sb.append(c);
            dfs(cur.children[i], sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<String> trimTo3(List<String> res){
        Collections.sort(res, (a, b) -> sen.get(a).equals(sen.get(b)) ? a.compareTo(b) : sen.get(b) - sen.get(a));
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < Math.min(res.size(), 3); i++){
            ret.add(res.get(i));
        }
        return ret;
    }


}
