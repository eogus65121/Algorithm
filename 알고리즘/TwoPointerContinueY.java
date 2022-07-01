package 알고리즘;

import java.util.*;

// 투 포인터 알고리즘 연속성 존재
public class TwoPointerContinueY {
    public static void main(String[] args) {
        int answer = 0;
        // n = 배열의 크기, p = 만들기를 원하는 key값
//        int n = 4;
//        int p = 2;
//        int[] arr1 = {1, 1, 1, 1};
        int n1 = 10;
        int p1 = 5;
        int[] arr2 = {1,2,3,4,2,5,3,1,1,2};

        int right = 1;
        int left = 0;

        int target = 0;

        while(true){
            if(target >= p1){
                target -= arr2[left++];
            }
            else if(right == arr2.length) break;
            else if(target < p1){
                target += arr2[right++];
            }

            if(target == p1) answer++;
        }
    }
}
