package 프로그래머스.java;

public class 두정수사이의합 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            for(; min <= max; min++)    {answer += min;}
            return answer;
        }
    }
}
