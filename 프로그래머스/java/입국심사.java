package 프로그래머스.java;

import java.util.*;

public class 입국심사 {

    class Solution {
        // n : 입국 심사를 기다리는 인원
        // 심사관마다 걸리는 시간이 다름
        // 심사대, 인원 1:1 매칭
        // times : 심사관이 입국심사 하는데에 걸리는 시간
        //
        public long solution(int n, int[] times) {
            long answer = 0;
            long left = 0;
            long right = (long)n * (long)times[times.length-1];
            while(left <= right){
                long mid = (left + right) /2;
                long sum = 0;
                for(int i = 0; i < times.length; i++){
                    sum += mid / times[i];
                }
                if(sum < n){
                    left = mid + 1;
                }else {
                    right = mid -1;
                    answer = mid;
                }
            }
            return answer;
        }
    }
}
