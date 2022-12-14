package 백준.java.algorithm.dfs;

;import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class 단지번호붙이기 {
    // 정사각형 지도
    // 1 : 집이 있음, 0 : 집이 없음
    // 연결이 되어있는 경우 하나의 단지로 파악
    // 대각선 상의 경우 연결 된 것이 아님
    // 각 단지에 속하는 집의 수를 오름 차순으로 정렬하여 출력
    //asnwer =  3 7 8 9

    static List<Integer> rtnList = new ArrayList<>();
    static boolean[][] vst;
    static int cnt;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        int n = 7;
        int [][] map = {{0,1,1,0,1,0,0}
                ,{0,1,1,0,1,0,1}
                ,{1,1,1,0,1,0,1}
                ,{0,0,0,0,1,1,1}
                ,{0,1,0,0,0,0,0}
                ,{0,1,1,1,1,1,0}
                ,{0,1,1,1,0,0,0}};

        vst = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0) vst[i][j] = true;
                else vst[i][j] = false;
            }
        }

        while(true){
            int[] flag = chkMap(vst);
            if(flag[0] == -1) break;
            if(vst[flag[0]][flag[1]] == false) {
                dfs(map, new int[]{flag[0], flag[1]});
                rtnList.add(cnt);
                cnt = 0;
            }
        }
        Collections.sort(rtnList);
        System.out.println(rtnList.size());
        rtnList.stream().forEach(System.out::println);
    }

    public static void dfs(int[][] map, int[] start){
        vst[start[0]][start[1]] = true;
        cnt++;

        for(int i = 0; i < 4; i++){
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];
            if(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length){
                if(vst[nx][ny] == false){
                    dfs(map, new int[]{nx, ny});
                }
            }
        }

        // static dx, dy를 사용하지 않은 경우 해당 방법을 사용해도 됨 (이게 성능은 더 좋지만 가독성에서 떨어짐)
        /*if(start[0] > 0 && vst[start[0]-1][start[1]] == false) {
            vst[start[0]-1][start[1]] = true;
            dfs(map, new int[] {start[0]-1, start[1]});
        }
        if(start[1] > 0 && vst[start[0]][start[1]-1] == false){
            vst[start[0]][start[1]-1] = true;
            dfs(map, new int[] {start[0], start[1]-1});
        }
        if(start[1] < map.length-1 && vst[start[0]][start[1]+1] == false){
            vst[start[0]][start[1]+1] = true;
            dfs(map, new int[] {start[0], start[1]+1});
        }
        if(start[0] < map.length-1 && vst[start[0]+1][start[1]] == false){
            vst[start[0]+1][start[1]] = true;
            dfs(map, new int[] {start[0]+1, start[1]});
        }*/

    }

    public static int[] chkMap(boolean[][] vst){
        for(int i = 0; i < vst.length; i++){
            for(int j = 0; j < vst[i].length; j++){
                // 방문 해야될 노드가 남음
                if(vst[i][j] == false) return new int[]{i, j};
            }
        }
        // 모두 방문함
        return new int[]{-1, -1};
    }
}
