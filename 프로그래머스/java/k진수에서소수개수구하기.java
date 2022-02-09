import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String cn = convNum(n, k);
        String[] s_cn = cn.split("0");

        for(String s : s_cn){
            if(s.equals("") || s.equals("1")) continue;
            if(isPrime(Long.parseLong(s))){
                answer++;
            }
        }
        return answer;
    }
    private String convNum(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n > k){
            sb.append(n%k);
            n /= k;
        }
        sb.append(Integer.toString(n));
        return sb.reverse().toString();
    }

    private boolean isPrime(long num){
        if(num == 2) return true;
        for(int i = 3; i < Math.sqrt(num) + 1; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}