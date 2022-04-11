package 프로그래머스.java;
import java.util.*;

public class 단어변환 {

    class Solution {
        public int solution(String begin, String target, String[] words) {
            boolean[] vst = new boolean[words.length];
            Arrays.fill(vst, true);
            return bfs(begin, words, vst, 0, target);
        }

        private int bfs(String begin, String[] words, boolean[] vst, int cnt, String target){
            Queue<String> q = new LinkedList<String>();
            q.add(begin);
            while(!q.isEmpty()){
                String str = q.poll();
                if(str.equals(target)) return cnt;
                int n = 0;
                for(int i = 0; i < words.length; i++){
                    if(chkStr(str, words[i]) && vst[i]){
                        n++;
                        q.add(words[i]);
                        vst[i] = false;
                    }
                }
                if(n > 1) cnt -= n;
                cnt++;
            }
            return 0;
        }

        private boolean chkStr(String s1, String s2){
            int cnt = 0;
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)) cnt++;
            }
            return cnt == 1 ? true : false;
        }
    }
}
