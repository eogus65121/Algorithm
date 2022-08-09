package 프로그래머스.java;
import java.util.*;

public class 피로도 {

    class Solution {
        List<Integer> rtnPermuList = new ArrayList<>();

        public int solution(int k, int[][] dungeons) {
            int answer = 0;
            int len = dungeons.length;
            int[] arr = new int[len];
            int[] output = new int[len];
            boolean[] vst = new boolean[len];
            for(int i = 0; i < len; i++) arr[i] = i;
            permu(arr,output, vst, 0, len, len);

            int cnt = 0, p = k;
            for(int i = 0; i < rtnPermuList.size(); i++){
                if(p >= dungeons[rtnPermuList.get(i)][0]){
                    p -= dungeons[rtnPermuList.get(i)][1];
                    cnt++;
                }else{
                    answer = Math.max(answer, cnt);
                    cnt = 0;
                    p = k;
                    i += len - (i%len+1);
                }
                if(cnt == len){
                    answer = len;
                    break;
                }
            }

            return answer;
        }

        private void permu(int[] arr,int[] output, boolean[] vst, int depth, int n, int r){
            if(depth == r){
                for(int i : output) rtnPermuList.add(i);
                return;
            }

            for(int i = 0; i < n; i++){
                if(vst[i] != true){
                    vst[i] = true;
                    output[depth] = arr[i];
                    permu(arr,output, vst, depth+1, n, r);
                    vst[i] = false;
                }
            }
        }
    }
}
