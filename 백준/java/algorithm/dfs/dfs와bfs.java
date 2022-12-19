package 백준.java.algorithm.dfs;

import java.io.IOException;
import java.util.*;

class dfs와bfs {

    static boolean[] vst;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();


        map = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }
        vst = new boolean[n+1];
        vst[0] = true;

        dfs(map, v);
        Arrays.fill(vst, false);
        vst[0] = true;
        System.out.println();
        bfs(map, v);

    }

    public static void bfs(int[][] map, int startIdx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(startIdx);
        vst[startIdx] = true;
        System.out.print(startIdx);

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i = 1; i < map[temp].length; i++){
                if(map[temp][i] == 1 && vst[i] == false){
                    q.offer(i);
                    vst[i] = true;
                    System.out.print(" " + i);
                }
            }
        }
    }

    public static void dfs(int[][] map, int startIdx){
        System.out.print(startIdx + " ");
        vst[startIdx] = true;
        for(int i = 1; i < map[startIdx].length; i++){
            if(map[startIdx][i] == 1 && vst[i] == false){
                dfs(map, i);
            }
        }
    }
}
