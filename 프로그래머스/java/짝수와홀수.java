package 프로그래머스.java;

public class 짝수와홀수 {
    class Solution {
        public String solution(int num) {
            String answer = (num%2 == 0)? "Even" : "Odd";
            return answer;
        }
    }
}
