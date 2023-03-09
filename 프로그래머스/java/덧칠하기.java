package 프로그래머스.java;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class 덧칠하기 {

    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            if(m == 1) return section.length;
            Set<Integer> set = new HashSet<>();
            for(int i : section) set.add(i);

            while(!set.isEmpty()){
                Integer[] temp = set.toArray(new Integer[0]);
                Arrays.sort(temp);
                for(int i = 0; i < m; i++){
                    if(set.contains(temp[0]+i)){
                        set.remove(temp[0]+i);
                    }
                }
                answer++;
            }
            return answer;
        }
    }

    // 다른 풀이
    // 페인트를 칠하는 범위를 기준으로 다음 구역이 범위보다 작으면 pass,
    // 구역보다 클 경우 count++, 시작 기준 변경
    public int solution2(int n, int m, int[] section) {
        int range = section[0];
        int answer = 1;

        for(int i = 1; i < section.length; i++){
            if(range + m -1 < section[i]){
                answer++;
                range = section[i];
            }
        }
        return answer;
    }
}
