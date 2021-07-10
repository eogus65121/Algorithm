package 프로그래머스.java;
import java.util.Arrays;

class 소수찾기 {
    public int solution(int n) {
        int answer = 0;

        // 에라토스테네스의 체
        int[] filter = new int[n + 1];
        Arrays.fill(filter, 1);
        filter[0] = 0;
        filter[1] = 0;

        for (int i = 2; i < Math.sqrt(n) + 1; i++){

            if (filter[i] == 1){
                for (int j = i * 2; j <= n; j+=i){
                    filter[j] = 0;
                }
            }
        }

        for (int check: filter){
            if (check == 1){
                answer++;
            }
        }

        return answer;
    }
}

// 다른 풀이 (에라토스테네스의 체 효율이 더 좋다)

class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n < 2) return answer = 0;
        int flag = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <=Math.sqrt(i); j++){
                if(i%j==0){
                    if(i!=j){
                        flag = 0;
                        break;
                    }
                }
            }
            if(flag == 1){
                answer++;
            }
            flag=1;
        }
        return answer;
    }
}
