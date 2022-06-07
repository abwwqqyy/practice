package QW;

public class LC702SearchInSSortedArrayOfUnknownSize {
    class ArrayReader { // dummy class
        public int get(int index) {
            return 0;
        }
    }
    public int search(ArrayReader reader, int target) {
        int MAX = Integer.MAX_VALUE;
        int r = 10000;
        int l = 0;
        while(l < r){
            int mid = (l + r) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) == MAX || reader.get(mid) > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
// time O(logn) space O(1)
