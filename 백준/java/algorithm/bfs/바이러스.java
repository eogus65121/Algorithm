package 백준.java.algorithm.bfs;

;import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class 바이러스 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt(); // 컴퓨터의 수
//        int m = scan.nextInt(); // 네트워크 상에서 직접 연결되어있는 컴퓨터 쌍의 수
        int n = 7;
        int m = 6;
        List<String[]> list = new ArrayList<>();
        int[][] map = new int[n+1][n+1];
        boolean[] vst = new boolean[n+1];
        Arrays.fill(vst, true);

//        for(int i = 0; i < m; i++){
//            int a = scan.nextInt();
//            int b = scan.nextInt();
//            map[a][b] = map[b][a] = 1;
//        }

        int[][] temp = {{1,2}, {2,3}, {1,5}, {5,2}, {5,6}, {4,7}};

        for(int i = 0; i < temp.length; i++){
            int a = temp[i][0];
            int b = temp[i][1];
            map[a][b] = map[b][a] = 1;
        }

//        for(int i = 0; i < m; i++){
//
//        }

        bfs(map, vst, 1);
        System.out.println(cnt);

    }
    private static void bfs(int[][] map, boolean[] vst, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vst[start] = false;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 1; i < map[node].length; i++){
                if(map[node][i] == 1 && vst[i]){
                    q.add(i);
                    vst[i] = false;
                    cnt++;
                }
            }
        }
    }
}
