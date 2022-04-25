import java.util.*;

public class 가장먼노드 {

    class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            List<List<Integer>> vNodeList = new ArrayList<>();
            boolean[] vst = new boolean[n];
            Arrays.fill(vst, true); // ture = 방문 가능
            for(int i = 0; i < n; i++) {vNodeList.add(new ArrayList<Integer>());}
            for(int[] i : edge){
                vNodeList.get(i[0]-1).add(i[1]-1);
                vNodeList.get(i[1]-1).add(i[0]-1);
            }

            int[] rtnCnt = bfs(vNodeList, vst);

            int max = 0;

            for(int i : rtnCnt){
                if(max < i){
                    answer = 1;
                    max = i;
                }else if(max == i) answer++;
            }

            return answer;
        }

        private int[] bfs(List<List<Integer>> vNodeList, boolean[] vst){
            int[] cnt = new int[vNodeList.size()];
            Queue <Integer> q = new LinkedList<>();
            q.add(0);
            vst[0] = false;
            while(!q.isEmpty()){
                int node = q.poll();
                for(int i : vNodeList.get(node)){
                    if(vst[i]){
                        cnt[i] = cnt[node] + 1;
                        q.add(i);
                        vst[i] = false;
                    }
                }
            }
            return cnt;
        }
    }
}
