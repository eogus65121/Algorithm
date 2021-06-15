package 프로그래머스.java;

public class 문자열다루기기본 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            if(s.length() != 6 && s.length() != 4){
                answer = false;
            } else {
                for(int i = 0; i < s.length(); i++) {
                    char alpha = s.charAt(i);
                    if(alpha <'0' || alpha > '9') {
                        answer = false;
                    }
                }
            }
            return answer;
        }
    }
}
