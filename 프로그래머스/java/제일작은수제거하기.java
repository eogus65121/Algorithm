package 프로그래머스.java;

public class 제일작은수제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            int [] answer;
            int min = 1000;
            if(arr.length == 1) {
                answer = new int [1];
                answer[0] = -1;
            }else{
                answer = new int[arr.length-1];
                int index = 0;
                for(int i : arr) {
                    if(min > i) {min = i;}
                }
                for(int j = arr.length; j > 0; j--) {
                    if(j == min) {
                        continue;
                    } else{
                        System.out.println(arr[j]);
                        answer[index] = arr[j];
                        index++;
                    }
                }
            }
            return answer;
        }
    }
}
