package 프로그래머스.java;

public class 서울에서김서방찾기 {
    class Solution {
        public String solution(String[] seoul) {
            String answer = "";
            for(int i = 0; i < seoul.length; i++) {
                if(seoul[i].compareTo("Kim") == 0) {
                    answer = answer.concat("김서방은 " + i + "에 있다");
                    break;
                }
            }
            return answer;
        }
    }
}
