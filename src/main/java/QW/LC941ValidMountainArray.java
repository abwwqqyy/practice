package QW;

public class LC941ValidMountainArray {
    public static boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3,2,1};
        int[] arr2 = new int[]{2,3,2,1};
        int[] arr3 = new int[]{1,2,3,4};
        int[] arr4 = new int[]{1,2,3,1};
        System.out.println(validMountainArray(arr1));//f
        System.out.println(validMountainArray(arr2));//t
        System.out.println(validMountainArray(arr3));//f
        System.out.println(validMountainArray(arr4));//t

    }
}
