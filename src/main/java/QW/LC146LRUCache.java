package QW;

import java.util.HashMap;
import java.util.Map;


public class LC146LRUCache {
    class DNode{
        int key;
        int val;
        DNode prev;
        DNode next;
        public DNode(){}
        public DNode(int k, int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    class DList{
        DNode head;
        DNode tail;
        int size;
        public DList(){
            head = null;
            tail = null;
            size = 0;
        }
        public int size(){
            return size;
        }
        public void add(DNode node){
            if(size == 0){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                node.prev = tail;
                tail = node;
                node.next = null;
            }
            size++;
        }
        public DNode pollFirst(){
            if(size == 0) {
                return head;
            }
            DNode ret = head;
            remove(head);
            return ret;
        }
        public void remove(DNode node){
            if(node == head){
                DNode newHead = head.next;
                if(newHead != null){
                    newHead.prev = null;
                }
                head.next = null;
                head = newHead;
            }else if(node == tail){
                DNode newTail = tail.prev;
                if(newTail != null){
                    newTail.next = null;
                }
                tail.prev = null;
                tail = newTail;
            }else{
                DNode prevNode = node.prev;
                prevNode.next = node.next;
                node.next.prev = prevNode;
                node.prev = null;
                node.next = null;
            }
            size --;
        }
    }
    Map<Integer, DNode> map;
    DList cache;
    int cap;
    public LC146LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DList();
        cap = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DNode cur = map.get(key);
        cache.remove(cur);
        cache.add(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        DNode cur = new DNode(key, value);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.add(cur);
            map.put(key, cur);
        }else{
            if(map.size() == cap){
                DNode rm = cache.pollFirst();
                // System.out.println(map + "  " + cache + " size: " + cache.size());
                map.remove(rm.key);
            }
            map.put(key, cur);
            cache.add(cur);
        }
    }
}
