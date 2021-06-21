package 프로그래머스.java;

public class 평균구하기 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;
            for(double i : arr) {answer += i;}
            answer = answer/arr.length;
            return answer;
        }
    }
}
