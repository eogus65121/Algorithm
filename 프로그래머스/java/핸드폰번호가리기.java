package 프로그래머스.java;

public class 핸드폰번호가리기 {
    class Solution {
        public String solution(String phone_number) {
            String []number = phone_number.split("");
            for(int i = 0; i < number.length-4; i++) {
                number[i] = "*";
            }
            String answer = String.join("", number);
            return answer;
        }
    }
}
