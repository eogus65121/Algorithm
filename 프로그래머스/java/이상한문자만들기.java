package 프로그래머스.java;

public class 이상한문자만들기 {
    class Solution {
        public String solution(String s) {
            String [] str = s.split("");
            int num = 0;
            for(int i = 0; i< str.length; i++){
                if(str[i].charAt(0) != ' '){
                    if(num % 2 == 1) {
                        str[i] = str[i].toLowerCase();
                    }else if(num % 2 == 0) {
                        str[i] = str[i].toUpperCase();
                    }
                    num+=1;
                }else {
                    num = 0;
                    continue;
                }
            }
            String answer = String.join("", str);
            return answer;
        }
    }
}
