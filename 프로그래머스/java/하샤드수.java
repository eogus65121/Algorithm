package 프로그래머스.java;

public class 하샤드수 {
    class Solution {
        public boolean solution(int x) {
            int div = 10;
            int sum = 0;
            int xx = x;
            while(x > 0) {
                sum += x % div;
                x /= 10;
            }
            if(xx % sum != 0){
                return false;
            }
            return true;
        }
    }
}
