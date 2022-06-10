import java.util.*;

class Solution {
    public long solution(int n) {
        // 피보나치
        long answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        if(n == 1) return 1;
        else {   
            for(int i = 0; i < n-1; i++){
                list.add(((list.get(i) + list.get(i+1))) % 1234567) ;
            }   
        }
        return list.get(n) % 1234567;
    }
}