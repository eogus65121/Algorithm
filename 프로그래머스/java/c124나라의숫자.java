package 프로그래머스.java;

public class c124나라의숫자 {
    class Solution {
        public String solution(int n) {
            String answer = "";
            String [] rest_num = {"4", "1", "2"};
            
            while(n > 0) {
                answer = rest_num[n%3] + answer;
                n = (n-1)/3;
            }
            return answer;
        }
    }
}
