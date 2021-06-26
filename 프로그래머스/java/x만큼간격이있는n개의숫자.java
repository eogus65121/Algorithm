package 프로그래머스.java;

public class x만큼간격이있는n개의숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long [n];
            int i = 0;
            long sum = (long)x;
            do{
                answer[i++] = sum;
                sum+=(long)x;
            }while(i < n);
            return answer;
        }
    }
}
