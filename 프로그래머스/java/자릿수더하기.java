package 프로그래머스.java;

public class 자릿수더하기 {
    public class Solution {
        public int solution(int n) {
            int answer = 0;
            int div = 10;
            
            while(true) {
                answer += (n % div);
                n /= 10;
                if(n == 0) {
                    break;
                }
            }
            return answer;
        }
    }
}
