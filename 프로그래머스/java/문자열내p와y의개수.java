package 프로그래머스.java;

public class 문자열내p와y의개수 {
    class Solution {
        public static boolean solution(String s) {
            s = s.toLowerCase();
            int p_num = 0;
            int y_num = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.substring(i, i+1).compareTo("p") == 0)   {p_num++;}
                if(s.substring(i, i+1).compareTo("y") == 0)   {y_num++;}
            }
            return p_num == y_num;
        }
    }
}
