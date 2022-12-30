package 프로그래머스.java;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


// 코드 참고
class 위클리챌린지9주차 {
    public int solution(int n, int[][] wires) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        int min = n;
        for(int[] wire : wires){
            min = Math.min(min, bfs(wire[0],wire[1],graph));
        }
        return min;
    }
    
    public static int bfs(int start, int ignore, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        int cur;
        while (!queue.isEmpty()){
            count++;
            cur = queue.poll();
            visited[cur] = true;
            for(int elem : graph.get(cur)){
                if(elem == ignore || visited[elem]) continue;
                queue.add(elem);
            }
        }
        return Math.abs((graph.size()-1-count)-count);
    }
}

// 다른사람 코드

/**
 * class Solution {
    int N, min;
    int[][] map;
    int[] vst;
    int dfs(int n){
        vst[n] = 1;
        int child = 1;
        for(int i = 1; i <= N; i++) {
            if(vst[i] == 0 && map[n][i] == 1) {
                vst[i] = 1;
                child += dfs(i);
            }
        }
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }
    public int solution(int n, int[][] wires) {
        N = n;
        min = n;
        map = new int[n+1][n+1];
        vst = new int[n+1];
        for(int[] wire : wires) {
            int a = wire[0], b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }
}
 * 
 */