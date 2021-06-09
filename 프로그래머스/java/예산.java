package 프로그래머스.java;

import java.util.Arrays;

public class 예산 {
    class Solution {
        public int solution(int []d, int budget) {
            int result =0;
            int answer = 0;
            Arrays.sort(d);
            for(answer = 0; answer<=d.length-1; answer++) {
                if((result + d[answer]) <= budget) {
                    result += d[answer];
                } else {
                    break;
                }
            }
            return answer;
        }
    }
}
