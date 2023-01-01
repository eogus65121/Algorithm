package 백준.java.algorithm.bfs;

import java.io.IOException;
import java.util.*;

class 연결요소개수 {
    static boolean[] vst;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        vst = new boolean[n+1];
        vst[0] = true;
        map = new int[n+1][n+1];
        int first, second;
        for(int i = 0; i < m; i++){
            first = sc.nextInt();
            second = sc.nextInt();
            map[first][second] = 1;
            map[second][first] = 1;
        }

        while(true){
            int flag = chkMap();
            if(flag == 0) break;
            else{
                bfs(flag);
            }
            answer++;
        }

        System.out.println(answer);
    }

    // 방문하지 않은 지점이 있는지 확인
    public static int chkMap(){
        for(int i = 0; i < vst.length; i++){
            if(vst[i] == false){
                return i;
            }
        }
        return 0;
    }

    // bfs 탐색 알고리즘
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        vst[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < map[node].length; i++){
                if(map[node][i] == 1 && vst[i] == false){
                    q.offer(i);
                    vst[i] = true;
                }
            }
        }
    }
}