package 프로그래머스.java;

public class 포켓몬 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            
            for(int i = 0; i < nums.length-1; i++) {
                int min = i;
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[min] > nums[j]) {
                        int temp = nums[min];
                        nums[min] = nums[j];
                        nums[j] = temp;
                    }
                }
            }// 오름차순 정렬
            
            for(int i = 0; i <= nums.length-1; i++) {
                if(i > 0) {
                    if(nums[i-1] == nums[i]) {
                        continue;
                    } else {
                        answer++;
                    }
                } else {
                    answer++;
                }
                if(answer == nums.length/2) {
                    break;
                }
            }
            
            return answer;
        }
    }
}
