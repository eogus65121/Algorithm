package 프로그래머스.java;

public class 약수의합 {
    class Solution {
        public static int solution(int n) {
            int answer = n;
            for(int i = 1; i <= n/2; i++) {
                if(n%i == 0) {
                    answer+=i;
                }
            }
            return answer;
        }
    }
}
