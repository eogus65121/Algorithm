package 프로그래머스.java;
import java.util.ArrayList;

public class 모의고사 {
    class Solution {
        public int [] solution(int [] answers){
            int [][] supo = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4,2, 5}, {3, 3, 1, 1, 2, 2 ,4, 4, 5, 5}};
            int [] answer;
            ArrayList <Integer> list = new ArrayList<>();
            ArrayList <Integer> list_max = new ArrayList<>();
            
            for(int num = 0; num < 3; num++) {
                int count = 0;
                for(int p_num = 0; p_num < answers.length; p_num++) {
                    if(answers[p_num] == supo[num][p_num%(supo[num].length)]) {
                        count++;
                    }
                }
                list.add(num, count);
            }
            int max = Math.max(Math.max(list.get(0), list.get(1)), list.get(2));
            for(int index_i = 0; index_i < 3; index_i++) {
                if(max == list.get(index_i)) list_max.add(index_i+1);
            }
            answer = new int[list_max.size()];
            for(int i = 0; i<list_max.size(); i++) {
                answer[i] = list_max.get(i);
            }
            return answer;
        }
    }
}
