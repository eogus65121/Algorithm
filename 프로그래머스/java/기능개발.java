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

/*  다시 풀어본 코드
import java.util.*;

class Solution{
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>(); // days 값을 저장하기 위한 q
        List<Integer> list = new ArrayList<>(); // answer 배열로 변환하기 위한 list
        for (int i = 0; i < progresses.length; i++) {
            int days;
            if ((100 - progresses[i]) % speeds[i] == 0) { // 0인 경우와 아닌경우 차이 생김
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        int temp = q.poll();  
        int cnt = 1;
        while (true) {
            if (!q.isEmpty()) {  //queue에 값이 없을 때까지 반복
                if (temp >= q.peek()) {   // 값 비교 후 앞에 뽑았던 값보다 클 경우 list 저장
                    q.poll();             // 아닐경우 pass
                    cnt++;
                } else {
                    list.add(cnt);
                    temp = q.poll();
                    cnt = 1;
                }
            } else {
                list.add(cnt);
                break;
            }
        }
        answer = new int[list.size()];  // list를 answer로 옮기는 작업
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}
*/