package 백준.java.algorithm.greedy;

import java.io.IOException;
import java.util.Scanner;

class 뒤집기 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = s.charAt(0);
        int oneCnt = 0, twoCnt = 1, changeCnt = 0;
        for(int i = 0; i < s.length();  i++){
            if(c == s.charAt(i)) continue;
            if(changeCnt % 2 == 0) oneCnt++;
            else twoCnt++;
            changeCnt++;
            c = s.charAt(i);
        }
        System.out.println(Math.min(oneCnt, twoCnt));
    }

}
