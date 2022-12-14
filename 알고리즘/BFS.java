package 알고리즘;

import java.util.*;

public class BFS {

    static List<Integer> rtnList = new ArrayList<>();

    public static void main(String[] args) {
        // 문제제공 예시
        boolean[] vst = new boolean[9];
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
        bfs1(graph, vst, 1);
    }

    // 최단거리, 일반적인 bfs 알고리즘
    public static void bfs1(int[][] graph, boolean[] vst, int nodeIdx){
        Queue<Integer> q = new LinkedList<>();

        q.offer(nodeIdx);
        vst[nodeIdx] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int n : graph[node]){
                if(vst[n] == false){
                    q.offer(n);
                    vst[n] = true;
                }
            }
        }
    }

    //todo 최단거리를 구하되 조건이 여러 개 존재하는 경우에 대한 변형 bfs 알고리즘 작성 예정
    public static void bfs2(){
        //
    }


}
