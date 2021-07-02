package 프로그래머스.java;

import java.util.ArrayList;

public class 기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> list = new ArrayList<>();
            int[] answer;
            int [] comp_t = new int[progresses.length];
            for(int i=0; i < progresses.length; i++) {
                int time = 1;
                for(int j = 0; j < 100; j++) {
                    if(100 <= (speeds[i] * time) + progresses[i])   {break;}
                    time++;
                }
                comp_t[i] = time;
            }
            int q = 0;
            for(int i = 0; i < comp_t.length; i++) {
                int temp_t = 1;
                for(q = i; q < comp_t.length-1; q++) {
                    if(comp_t[i] < comp_t[q+1]){
                        break;
                    }
                    temp_t++;
                }
                i = q;
                list.add(temp_t);
            }
            answer = new int[list.size()];
            int index = 0;
            for(int t : list) {
                answer[index++] = t;
            }
            return answer;
        }
    }
}
