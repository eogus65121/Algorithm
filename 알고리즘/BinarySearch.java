package 알고리즘;

public class BinarySearch{
    static int idx;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6 };
        binarySearch(6, arr, arr.length-1, 0);
        System.out.println(idx);
    }

    private static void binarySearch(int key, int[] arr, int high, int low){
        if(low <= high){
            int mid = (low + high) /2;
            if(arr[mid] == key){
                idx = mid;
                return;
            }else if(arr[mid] > key){
                binarySearch(key, arr, mid-1, low);
            }else if(arr[mid] < key){
                binarySearch(key, arr, high, mid+1);
            }
        }else{
            idx = -1;
        }
    }
}