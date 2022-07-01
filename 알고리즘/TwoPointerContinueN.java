package 알고리즘;

import java.util.Arrays;

// 투 포인터 연속성 존재X
// 배열 i~j까지 (개수 기준 X) 합을 했을 때 target 값과 동일하게 된 경우의 cnt
// 정렬 후 최대값과 최소값을 기준으로 좌우의 인덱스를 체크
public class TwoPointerContinueN {
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
