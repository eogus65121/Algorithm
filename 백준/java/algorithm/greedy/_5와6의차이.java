package 백준.java.algorithm.greedy;

import java.io.IOException;
import java.util.*;

class _5와6의차이 {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        String a = temp[0];
        String b = temp[1];

        int aMax = Integer.parseInt(a.replaceAll("5", "6"));
        int aMin = Integer.parseInt(a.replaceAll("6", "5"));
        int bMax = Integer.parseInt(b.replaceAll("5", "6"));
        int bMin = Integer.parseInt(b.replaceAll("6", "5"));

        System.out.print((aMin + bMin) + " " + (aMax + bMax));
    }
}
