package 백준.java.algorithm.greedy;

import java.io.IOException;
import java.util.Scanner;

class A와B{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(sc.nextLine());

        while(str.length() != sb.length()){
            if(sb.charAt(sb.length() - 1) == 'A'){
                sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        System.out.println(str.equals(sb.toString()) ? 1 : 0);
    }
}