package 프로그래머스.java;

public class 2016년 {
    class Solution {
        public static String solution(int a, int b) {
            String answer = "";
            int [] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String [] day = {"SUN", "MON", "TUE", "WEN", "THU", "FRI", "SAT"};
            int d_select = 0;
            
            for(int i = 0; i < a-1; i++){
                d_select  = month[i] + 1;
            }
            answer = day[(d_select-1)%7];
            return answer;
        }
        public static void main(String[] args) {
            int a = 5;
            int b = 24;
            solution(a, b);
        }
    }
}
