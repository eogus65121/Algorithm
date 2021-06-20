package 프로그래머스.java;

public class 정수제곱근판별 {
class Solution {
    public long solution(long n) {
        double num = Math.sqrt((double)n);
        if(num == (int)num) {return (((long)num+1) * ((long)num+1));}
        else    {return -1;}
    }
}
}
