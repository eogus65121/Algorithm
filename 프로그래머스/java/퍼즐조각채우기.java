import java.util.*;

public class 퍼즐조각채우기 {

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[0].length; j++){
                game_board[i][j] = game_board[i][j] == 1 ? 0 : 1;
            }
        }
        Map<Integer, List<int[]>> puzzle_map = new HashMap<>();
        Map<Integer, List<int[]>> board_map = new HashMap<>();
        find_puzzle(puzzle_map, table);
        find_puzzle(board_map, game_board);

        for(int i = 0; i < board_map.size(); i++){
            for(int j = 0; j < puzzle_map.size(); j++){
                if(board_map.get(i).size() == puzzle_map.get(j).size()){
                    if(match_puzzle(make_arr(board_map.get(i)), make_arr(puzzle_map.get(j)), 0) == 1){
                        answer += puzzle_map.get(j).size();
                        board_map.get(i).clear();
                        puzzle_map.get(j).clear();
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    private int match_puzzle(int [][] board, int[][] puzzle, int cnt){
        if(cnt == 4){
            return 0;
        }
        if(board.length != puzzle.length || board[0].length != puzzle[0].length){
            return match_puzzle(board,rotate_puzzle(puzzle), cnt+1);
        }else {
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j < puzzle[0].length; j++) {
                    if (board[i][j] != puzzle[i][j]) {
                        return match_puzzle(board, rotate_puzzle(puzzle), cnt + 1);
                    }
                }
            }
        }
        return 1;
    }

    private int[][] rotate_puzzle(int[][] puzzle){
        int n = puzzle.length;
        int m = puzzle[0].length;
        int [][] rotate = new int[m][n];

        for(int i = 0; i < rotate.length; i++){
            for(int j = 0; j < rotate[0].length; j++){
                rotate[i][j] = puzzle[n-1-j][i];
            }
        }
        return rotate;
    }

    private int[][] make_arr(List<int[]> list){
        int row;
        int column;
        List<Integer> temp_row = new ArrayList<>();
        List<Integer> temp_column = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            temp_row.add(list.get(i)[0]);
        }
        row = Collections.max(temp_row) - Collections.min(temp_row) + 1;

        for(int i = 0; i < list.size(); i++){
            temp_column.add(list.get(i)[1]);
        }
        column = Collections.max(temp_column) - Collections.min(temp_column) + 1;
        int [][] arr = new int[row][column];

        for(int i = 0; i < list.size(); i++){
            arr[list.get(i)[0]-Collections.min(temp_row)][list.get(i)[1]-Collections.min(temp_column)] = 1;
        }

        return arr;
    }
    private void find_puzzle(Map<Integer, List<int[]>> map, int [][] table){
        int cnt = 0;
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                if(table[i][j] == 1){
                    table[i][j] = 0;
                    map.put(cnt++, add_puzzle_node(i, j, table));
                }
            }
        }
        return;
    }

    private List<int[]> add_puzzle_node(int y, int x, int[][] table){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int []{y, x});
        List<int []> list = new ArrayList<>();
        list.add(new int[]{y, x});
        while(!q.isEmpty()){
            int []node = q.poll();
            if(node[0] < table.length-1 && table[node[0]+1][node[1]] == 1){
                list.add(new int[]{node[0]+1, node[1]});
                table[node[0]+1][node[1]] = 0;
                q.add(new int []{node[0]+1, node[1]});
            }
            if(node[1] < table[0].length-1 && table[node[0]][node[1]+1] == 1){
                list.add(new int[]{node[0], node[1]+1});
                table[node[0]][node[1]+1] = 0;
                q.add(new int []{node[0], node[1]+1});
            }
            if(node[0] > 0 && table[node[0]-1][node[1]] == 1){
                list.add(new int[]{node[0]-1, node[1]});
                table[node[0]-1][node[1]] = 0;
                q.add(new int []{node[0]-1, node[1]});
            }
            if(node[1] > 0 && table[node[0]][node[1]-1] == 1){
                list.add(new int[]{node[0], node[1]-1});
                table[node[0]][node[1]-1] = 0;
                q.add(new int []{node[0], node[1]-1});
            }
        }
        return list;
    }
}
}
