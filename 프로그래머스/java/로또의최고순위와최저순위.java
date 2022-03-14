package 프로그래머스.java;
import java.util.*;

public class 로또의최고순위와최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            HashSet<Integer> s = new HashSet<>();
            for(int i : lottos) s.add(i);
            s.remove(0);
            int cnt = 0;
            int size = 6-s.size();
            for(int i = 0; i < win_nums.length; i++){
                if(s.contains(win_nums[i])){
                    cnt++;
                    s.remove(win_nums[i]);
                }
            }
            return new int[] {Math.min(7-(cnt+size), 6), Math.min(7-cnt, 6)};
        }
    }
}
