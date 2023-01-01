package 프로그래머스.java;

public class 숫자카드나누기 {
    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;
            int gcdA = arrayA[0], gcdB = arrayB[0];
            boolean flag = true;
            for(int i = 1; i < arrayA.length; i++){
                gcdA = gcd(gcdA, arrayA[i]);
                gcdB = gcd(gcdB, arrayB[i]);
            }

            if(isGcd(arrayB, gcdA)) answer = Math.max(answer, gcdA);
            if(isGcd(arrayA, gcdB)) answer = Math.max(answer, gcdB);
            return answer;
        }

        // 최대 공약수 구하기
        private int gcd(int n, int m){
            if(m == 0) return n;
            return gcd(m, n%m);
        }

        // 최대 공약수로 나누어지는지 확인
        private boolean isGcd(int[] arr, int gcd){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] % gcd == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
