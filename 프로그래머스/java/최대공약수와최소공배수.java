package 프로그래머스.java;

public class 최대공약수와최소공배수 {
    class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int [2];
            if(m%n == 0){
                answer[0] = Math.min(n, m);
                answer[1] = Math.max(n, m);
            }else{
                for(int i = 1; i <= Math.min(n, m); i++) {
                    if(n%i == 0 && m % i == 0) {
                        answer[0] = i;
                        answer[1] = (n*m)/i;
                    }
                }
            }
            return answer;
        }
    }
}
