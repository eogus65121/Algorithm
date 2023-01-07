package 백준.java.algorithm.greedy;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class 게임을만든동준이{
    // n개의 게임
    // 각 단계를 클리어 할 떄마다 점수
    // 점수 = 쉬운 난이도 > 어려운 난이도
    // 특정 레벨의 점수를 감소 시키려고 한다 그 단계를 찾아야한다

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int[] arr = {5,3,7,5};
        int cnt = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) s.add(arr[i]);

        int num = s.pop();
        while(!s.isEmpty()){
            int temp = s.pop();
            if(num > temp) {
                num = temp;
                continue;
            }
            System.out.println(temp - num + 1);
            cnt += temp - num + 1;
            num--;
        }
        System.out.println(cnt);
    }
}