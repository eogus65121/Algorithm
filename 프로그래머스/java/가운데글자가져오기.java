package 프로그래머스.java;

public class 가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            if(s.length() != 0) {
                return s.substring((s.length()-1)/2, s.length()/2 +1);
            }
            return answer;
        }
    }
}
