package 알고리즘;

import java.util.*;

public class Permutation{
    public static void main(String[] args) {
        String[] arr = {"a", "b", "d"};
        int n = arr.length;
        int r = 2;
        boolean[] vst = new boolean[n];
        Arrays.fill(vst, true);
        String[] memo = new String[r];
        List<String[]> rtnList = new ArrayList<>();
        permutationtt(arr, r, memo, vst, 0, rtnList);

        for(String[] s : rtnList){
            for(String i : s){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void permutationtt(String[] arr, int endPoint, String[] memo, boolean[] vst, int depth, List<String[]> rtnList){
        if(endPoint == depth){
            rtnList.add(memo.clone());
            return;
        }else{
            for(int i = 0; i < arr.length; i++){
                if(vst[i]){
                    vst[i] = false;
                    memo[depth] = arr[i];
                    permutationtt(arr, endPoint, memo, vst, depth+1, rtnList);
                    vst[i] = true;
                }
            }
        }
    }
}