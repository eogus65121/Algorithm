package 프로그래머스.java;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class 두개뽑아서더하기 {
    class Solution {
        public int[] solution(int[] numbers) {
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < numbers.length-1; i++){
                for(int j = i+1; j<numbers.length; j++){
                    int num_sum = numbers[i] + numbers[j];
                    set.add(num_sum);
                }
            }
            int index= 0;
            int [] answer= new int[set.size()];
            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for(int k : list) {
                answer[index++] = k;
            }
            return answer;
        }
    }
}
