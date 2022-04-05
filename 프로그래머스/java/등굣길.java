package 프로그래머스.java;

public class 등굣길 {

    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] matrix = new int[n][m];
            for(int[] puddle : puddles) matrix[puddle[1]-1][puddle[0]-1] = -1;

            for(int i = 0; i < n; i++){
                if(matrix[i][0] == -1) break;
                else matrix[i][0] = 1;
            }

            for(int i = 0; i < m; i++){
                if(matrix[0][i] == -1) break;
                else matrix[0][i] = 1;
            }

            for(int i = 1; i < matrix.length; i++){
                for(int j = 1; j < matrix[0].length; j++){
                    if(matrix[i][j] == -1) continue;
                    if(matrix[i-1][j] == -1) matrix[i][j] = matrix[i][j-1];
                    else if(matrix[i][j-1] == -1) matrix[i][j] = matrix[i-1][j];
                    else{
                        matrix[i][j] = (matrix[i-1][j] + matrix[i][j-1]) % 1000000007;
                    }
                }
            }

            return matrix[n-1][m-1];
        }
    }

    /** Queue를 활용한 bfs 알고리즘으로 푼 코드 */
    /*import java.util.*;

    class Solution {
        // 집의 위치 (1,1);
        // 학교 좌표 (m, n);
        // 오른쪽 아래로만 움직이기
        // 물은 피하기
        public int solution(int m, int n, int[][] puddles) {
            int[][] matrix = new int[n][m];
            for(int i = 0; i < puddles.length; i++){
                matrix[puddles[i][1]-1][puddles[i][0]-1] = 1;
            }
            int[] start = {0, 0};
            return bfs(matrix, start);
        }

        public int bfs(int[][] matrix, int[] currPosition){
            Queue<int[]> q = new LinkedList<>();
            q.add(currPosition);
            int cnt = 0;
            int div = 1000000007;
            while(!q.isEmpty()){
                int[] position = q.poll();

                if(position[0] == matrix.length-1 && position[1] == matrix[0].length-1) {
                    cnt++;
                }else{
                    if(position[0]+1 < matrix.length && matrix[position[0]+1][position[1]] == 0){
                        int[] temp = {position[0]+1, position[1]};
                        q.add(temp);
                    }
                    if(position[1]+1 < matrix[0].length && matrix[position[0]][position[1]+1] == 0){
                        int[] temp = {position[0], position[1]+1};
                        q.add(temp);
                    }
                }
                cnt = cnt%div;
            }
            return cnt;
        }
    }*/
}
