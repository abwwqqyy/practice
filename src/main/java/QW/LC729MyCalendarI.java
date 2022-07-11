package QW;

import java.util.TreeMap;

public class LC729MyCalendarI {
    TreeMap<Integer,Integer> map;
    public LC729MyCalendarI() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevKey = map.floorKey(start);
        Integer nextKey = map.ceilingKey(start);
        if(prevKey == null && nextKey == null){
            map.put(start, end);
            return true;
        }else if(prevKey == null){
            if(nextKey >= end){
                map.put(start, end);
                return true;
            }
        }else if(nextKey == null){
            if(start >= map.get(prevKey)){
                map.put(start, end);
                return true;
            }
        }else{
            if(start >= map.get(prevKey) && nextKey >= end){
                map.put(start, end);
                return true;
            }
        }

        return false;
    }
}
// time O(nlogn) space O(n)
