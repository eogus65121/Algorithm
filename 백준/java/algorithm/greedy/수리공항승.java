package 백준.java.algorithm.greedy;

import java.io.IOException;
import java.util.Scanner;

class 수리공항승{
    // 길이가 L인 테이프 무한개
    // 가장 왼쪽에서 일정 떨어진 거리만큼 물이 샌다
    // 물이 새는 위치 좌 우 0.5만큼 간격을 더 줘야한다
    // 테이프의 최소 개수를 구하라

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int l = Integer.parseInt(temp[1]);

        String[] temp2 = sc.nextLine().split(" ");

        int[] pos = new int [1001];
        int tape = 0;

        // 물이 새는 곳을 표시
        for(int i = 0; i < n; i++){
            pos[Integer.parseInt(temp2[i])] = 1;
        }

        // 반복문을 돌면서 첫 시작지점에 테이프를 붙이고 테이프의 길이만큼 i에 더해주어
        // pos 배열에 물이 새는 위치가 있어도 뛰어넘어버린다.
        for(int i = 1; i < 1001; i++){
            if(pos[i] != 0){
                i += l-1;
                tape++;
            }
        }

        System.out.println(tape);
    }
}