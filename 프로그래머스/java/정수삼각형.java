package 프로그래머스.java;

public class 정수삼각형 {

    class Solution {
        public int solution(int[][] triangle) {
            for(int i = triangle.length-1; i > 0; i--){
                dp(triangle, triangle[i], i);
            }
            return triangle[0][0];
        }

        private void dp(int[][] triangle, int[] nums, int depth){
            for(int i = 0; i < nums.length-1; i++){
                triangle[depth-1][i] += Math.max(nums[i], nums[i+1]);
            }
        }
    }
}
