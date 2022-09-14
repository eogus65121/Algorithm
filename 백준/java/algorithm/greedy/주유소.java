package 백준.java.algorithm.greedy;

import java.io.*;
import java.util.*;
public class 주유소 {

    public class Main {
        //1키로에 1리터
        //처음 출발할 때 무조건 기름을 넣고 출발을 해야함
        public void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); // 주유소 개수
            int[] street = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] oilExp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();;
            long answer = 0;

            int lowerExp = Integer.MAX_VALUE;
            for(int i = 0; i < street.length; i++){
                lowerExp = Math.min(lowerExp, oilExp[i]);
                answer += Long.valueOf(street[i]) * Long.valueOf(lowerExp);
            }

            System.out.println(answer);
        }
    }
}
