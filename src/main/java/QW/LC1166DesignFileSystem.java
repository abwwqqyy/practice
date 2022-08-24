package QW;

import java.util.HashMap;
import java.util.Map;

public class LC1166DesignFileSystem {
    private class TN{
        Map<String, TN> children;
        boolean isBreak;
        Integer val;
        public TN(){
            children = new HashMap<>();
            isBreak = false;
            val = null;
        }
    }
    private TN root;
    public LC1166DesignFileSystem() {
        root = new TN();
    }
    private void add(String path, int value){
        String[] pArr = path.split("/");
        // System.out.println(Arrays.toString(pArr));
        TN cur = root;
        for(String p : pArr){
            // System.out.println(c);
            if(p.length() == 0) continue;
            if(cur.children.get(p) == null){
                cur.children.put(p, new TN());
            }
            cur = cur.children.get(p);
            cur.isBreak = true;
        }
        cur.val = value;
    }
    private int search(String path){ // -2 for no path, -1 for not created
        String[] pArr = path.split("/");
        TN cur = root;
        for(int i = 0; i < pArr.length; i++){
            String p = pArr[i];
            if(p.length() == 0) continue;
            if(cur.children.get(p) == null && i == pArr.length - 1){
                return -1;
            }
            if(cur.children.get(p) == null){
                // System.out.println(i + "  " + pArr.length);
                return -2;
            }
            cur = cur.children.get(p);
            if(!cur.isBreak && i == pArr.length - 1){
                return -1;
            }
            if(!cur.isBreak){
                // System.out.println(i + "  " + pArr.length);
                return -2;
            }
        }
        // System.out.println(cur.val);
        if(cur.val == null){
            return -1;
        }else{
            return cur.val;
        }
    }
    public boolean createPath(String path, int value) {
        int exist = search(path);
        // System.out.println(exist);
        if(exist == -1){
            add(path, value);
            return true;
        }else{
            return false;
        }
    }

    public int get(String path) {
        int exist = search(path);
        if(exist > 0){
            return exist;
        }else{
            return -1;
        }
    }
}

