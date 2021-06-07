package 프로그래머스.java;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int slice_front = commands[i][0];
            int slice_end = commands[i][1];
            int select_num = commands[i][2];
            for(int j = slice_front; j <= slice_end; j++) {
                list.add(array[j-1]);
            }
            Collections.sort(list);
            answer[i] = list.get(select_num-1);
        }
        return answer;
    }
}