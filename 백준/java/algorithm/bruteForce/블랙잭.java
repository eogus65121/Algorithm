package 백준.java.algorithm.bruteForce;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 블랙잭 {

    public class Main{
         List<Integer> list = new ArrayList<>();

        public  void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] temp1 = br.readLine().split(" ");
            int n = Integer.parseInt(temp1[0]);
            int key = Integer.parseInt(temp1[1]);

            String[] temp2 = br.readLine().split(" ");
            int[] arr = new int[temp2.length];
            for(int i = 0; i < temp2.length; i++){
                arr[i] = Integer.parseInt(temp2[i]);
            }

            int[] result = new int[arr.length];
            boolean[] vst = new boolean[arr.length];
            Arrays.fill(vst, true);
            comb(vst, arr, result, 0, 3, key);

            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        }

        public  void comb(boolean[] vst, int[] arr, int[] result, int n, int r, int key){
            if(r == 0){
                int temp = result[0] + result[1] + result[2];
                if(temp <= key) list.add(temp);
            }else {
                for(int i = n; i < arr.length; i++){
                    if(vst[i]){
                        vst[i] = false;
                        result[n] = arr[i];
                        comb(vst, arr, result, n+1, r-1, key);
                        vst[i] = true;
                    }
                }
            }

        }
    }
}
