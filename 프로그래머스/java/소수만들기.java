package 프로그래머스.java;

class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        for(int back_i = 0; back_i < nums.length-2; back_i++ ) {
            for(int middle_j = back_i+1; middle_j < nums.length-1; middle_j++) {
                for(int front_k = middle_j+1; front_k < nums.length; front_k++) {
                    int sum = nums[back_i] + nums[middle_j] + nums[front_k];
                    for(int num = 2; num < sum; num++) {
                        if(sum%num == 0){
                        	break;
                        	}
                        if(num == sum-1) {
                        	answer++;
                        }
                    }
                }
            }
        }
          return answer;
    }
}