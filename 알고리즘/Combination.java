package 알고리즘;

import java.util.*;

public class Combination{
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};
        int n = arr.length;
        int r = 3;
        String[] result = new String[r];
        boolean[] vst = new boolean[arr.length];
        Arrays.fill(vst, true);
        List<String[]> rtnList = new ArrayList<>();
        combination1(arr, vst, 0, r, result, rtnList);

        for(String[] i : rtnList){
            for(String j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void combination1(String[] arr, boolean[] vst, int start,int end, String[]result, List<String[]> rtnList){
        if(end == 0){
            rtnList.add(result.clone());
            return;
        }else{
            for(int i = start; i < arr.length; i++){
                vst[i] = false;
                result[start]=arr[i];
                combination1(arr, vst, start+1, end-1, result, rtnList);
                vst[i] = true;
            }
        }
    }
}