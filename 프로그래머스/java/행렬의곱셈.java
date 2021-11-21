class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr2[0].length; i++){ // arr2 가로 이동
            for(int j = 0; j < arr1.length; j++){// arr1 세로 이동
                for(int t = 0; t < arr1[0].length; t++){
                    answer[j][i] += arr1[j][t] * arr2[t][i];
                }
            }
        }
        return answer;
    }
}