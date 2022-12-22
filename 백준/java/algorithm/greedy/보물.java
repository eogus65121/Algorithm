package 백준.java.algorithm.greedy;

import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

class 보물 {
    public static void main(String[] args) throws IOException{
        // 길이가 n
        // 정수 배열 a, b
        // 함수 s
        // s의 값을 가장 작게 만들기 위해 a를 재배열, 단 b는 재배열하면 안됨
        // s의 최솟값 구해라
        //  * + * + 이 순서
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for(int i  = 0; i < k; i++){
            a.add(sc.nextInt());
        }
        for(int i  = 0; i < k; i++){
            b.add(sc.nextInt());
        }
        Collections.sort(a);
        Collections.sort(b);
        for(int i = 0; i < k; i++){
            answer += a.get(i) * b.get(k-i-1);
        }
        System.out.print(answer);
    }

}
