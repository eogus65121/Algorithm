package 프로그래머스.java;
import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            int [] answer;
            ArrayList <Integer> list = new ArrayList<>();
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] % divisor == 0) {
                    list.add(arr[i]);
                } else {
                    continue;
                }
            }
            if(list.size() == 0) {
                answer = new int [1];
                answer[0] = -1;
            } else {
                answer = new int[list.size()];
                int index = 0;
                for(int k : list)   {answer[index++] = k;}
            }
            return answer;
        }
    }
}
