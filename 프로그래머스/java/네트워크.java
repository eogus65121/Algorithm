package 프로그래머스.java;
import java.util.*;

public class 네트워크 {
    /** bfs를 활용한 풀이 */
    class Solution1 {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] vst = new boolean[n];
            Arrays.fill(vst, true); // true = 방문을 아직 안함

            for(int i = 0; i < vst.length; i++){
                if(vst[i]){
                    bfs(computers, vst, i);
                    answer++;
                }
            }
            return answer;
        }

        private void bfs(int[][] computers, boolean[] vst, int startIdx){
            Queue<Integer> q = new LinkedList<>();
            q.add(startIdx);
            vst[startIdx] = false;
            while(!q.isEmpty()){
                int index = q.poll();
                for(int i = 0; i < computers[index].length; i++){
                    if(vst[i] && index != i && computers[index][i] == 1){
                        q.add(i);
                        vst[i] = false;
                    }
                }
            }
        }
    }
    /** dfs를 사용한 풀이 */
    class Solution2 {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] vst = new boolean[n];
            Arrays.fill(vst, true);
            for(int i = 0; i < vst.length; i++){
                if(vst[i]){
                    dfs(computers, vst, i);
                    answer++;
                }
            }
            return answer;
        }

        private void dfs(int[][] computers, boolean[] vst, int start){
            vst[start] = false;
            for(int i = 0; i < computers[start].length; i++){
                if(computers[start][i] == 1 && vst[i]){
                    dfs(computers, vst, i);
                }
            }

        }
    }
}
