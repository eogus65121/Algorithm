package 프로그래머스.java;
import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
    class Solution {
        public long solution(long n) {
            String[] n_split = String.valueOf(n).split("");
            Arrays.sort(n_split, Collections.reverseOrder());
            long answer = Long.parseLong(String.join("", n_split));
            return answer;
        }
    }
}
