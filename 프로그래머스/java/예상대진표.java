package 프로그래머스.java;

public class 예상대진표 {
    class Solution
    {
        public int solution(int n, int a, int b) {
            int answer = 0;
            while(a!=b) {
                if(a %2 == 0) {
                    a/=2;
                } else {
                    a /= 2;
                    a++;
                }
                if(b%2 == 0) {
                    b/=2;
                } else {
                    b /= 2;
                    b++;
                }
                answer++;
            }
            return answer;
        }
    }
}
