package 프로그래머스.java;

public class 자연수뒤집어배열로만들기 {
    class Solution {
        public int[] solution(long n) {
            int [] answer;
            String [] n_split = String.valueOf(n).split("");
            answer = new int[n_split.length];
            int n_len = n_split.length-1;
            
            for(int i = 0; i < n_split.length; i++) {
                answer[i] = Integer.parseInt(n_split[n_len]);
                n_len -= 1;
            }
            return answer;
        }
    }
}
