package 프로그래머스.java;

public class 행렬테두리회전하기 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int [queries.length];
            int [][] graph = new int[rows][columns];
            int temp = 1;
            for(int i=0; i < rows; i++){
                for(int j =0; j<columns; j++) graph[i][j] = temp++;
            }
            int min = rows * columns;
            temp = 0;
            for(int []query : queries){
                answer[temp++] = rotation(graph, query, min);
            }
            return answer;
        }
    
        private int rotation(int[][] graph, int []query, int min) {
            int x1 = query[1]-1;
            int y1 = query[0]-1;
            int x2 = query[3]-1;
            int y2 = query[2]-1;
            int temp1 = 0;
            int temp2 = 0;
    
            temp1 = graph[y1][x2];
            for(int t = 0; t < x2-x1; t++){
                graph[y1][x2-t] = graph[y1][x2-t-1];
                min = Math.min(min, graph[y1][x2-t]);
            }
    
            temp2 = graph[y2][x2];
            for(int t = 0; t < y2-y1-1; t++){
                graph[y2-t][x2] = graph[y2-1-t][x2];
                min = Math.min(min, graph[y2-t][x2]);
            }
            graph[y1+1][x2] = temp1;
            min = Math.min(min, temp1);
    
            temp1 = graph[y2][x1];
            for(int t = 0; t < x2-x1-1; t++){
                graph[y2][x1+t] = graph[y2][x1+1+t];
                min = Math.min(min, graph[y2][x1+t]);
            }
            graph[y2][x2-1] = temp2;
            min = Math.min(min, temp2);
    
            for(int t = 0; t < y2-y1-1; t++){
                graph[y1+t][x1] = graph[y1+1+t][x1];
                min = Math.min(min, graph[y1+t][x1]);
            }
            graph[y2-1][x1] = temp1;
            min = Math.min(min, temp1);
    
            return min;
        }
    }
}
