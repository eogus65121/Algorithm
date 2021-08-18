import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
    //return answer = 0cnt, 1cnt
    public static int[] solution(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int [2];
        // 전부 다 같은 값일 때
        if(arr[0][0] == arr[arr.length-1][arr.length-1]){
            int flag = 1;
            for(int [] arr_i : arr){
                for(int i = 0; i < arr_i.length; i++){
                    if(arr[0][0] != arr_i[i]){
                        flag = 0;
                        break;
                    }
                    else continue;
                }
            }
            if(flag == 1) {
                answer[arr[0][0]]++;
                return answer;
            }
        }

        divide(arr, 0, 0, arr.length/2, list);
        divide(arr, arr.length/2, 0, arr.length/2, list);
        divide(arr, 0, arr.length/2, arr.length/2, list);
        divide(arr, arr.length/2, arr.length/2, arr.length/2, list);
        answer[0] = Collections.frequency(list, 0);
        answer[1] = Collections.frequency(list, 1);
        return answer;
    }

    private static void divide(int [][] arr, int startX, int startY, int size, List<Integer>list){
        if(size == 1) {
            list.add(arr[startY][startX]);
            return;
        }
        int flag = 1;
        int temp = arr[startY][startX];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(temp != arr[startY+i][startX+j]){
                    flag = 0;
                    break;
                }
            }
        }
        if(flag == 0){
            divide(arr, startX, startY, size/2, list);
            divide(arr, startX+size/2, startY, size/2, list);
            divide(arr, startX, startY+size/2, size/2, list);
            divide(arr, startX+size/2, startY+size/2, size/2, list);
        }else{
            list.add(temp);
        }
    }
}