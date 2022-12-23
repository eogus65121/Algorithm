package 백준.java.algorithm.greedy;

import java.util.*;
import java.io.IOException;

class ATM {
    public static void main(String[] args) throws IOException{
        // 사람 인원 수 n
        // i번 사람이 돈을 인수하는데 걸리는 시간은 pi분이다
        // 줄을 서는 순서에 따라 돈을 인출하는데 필요한 시간의 합이 달라진다 (대기 시간이 있다는 말)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0, delay = 0;
        for(int i = 0; i < arr.length; i++){
            answer += delay + arr[i];
            delay += arr[i];
        }

        System.out.print(answer);
    }

}
