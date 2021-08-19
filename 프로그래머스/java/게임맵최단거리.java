import java.util.LinkedList;
import java.util.Queue;

class 게임맵최단거리{
    class Solution {
        public int solution(int[][] maps) {
            int answer = 0;
            int m = maps.length-1;
            int n = maps[0].length-1;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int []{0, 0, 1});

            while(!q.isEmpty()){
                int [] node = q.poll();

                if(node[0] == m && node[1] == n){
                    return node[2];
                }

                if(node[0]< m && maps[node[0]+1][node[1]] == 1){
                    maps[node[0]+1][node[1]] = 0;
                    q.add(new int[] {(node[0]+1), node[1], node[2]+1});
                }
                if(node[1]<n && maps[node[0]][node[1]+1] == 1){
                    maps[node[0]][node[1]+1] = 0;
                    q.add(new int[] {node[0], (node[1]+1), node[2]+1});
                }
                if(node[0]>0 && maps[node[0]-1][node[1]] == 1){
                    maps[node[0]-1][node[1]] = 0;
                    q.add(new int[]{(node[0]-1), node[1], node[2]+1});
                }
                if(node[1]>0 && maps[node[0]][node[1]-1] == 1){
                    maps[node[0]][node[1]-1] = 0;
                    q.add(new int[]{node[0], (node[1]-1), node[2]+1});
                }
            }
            return -1;
        }
    }
}