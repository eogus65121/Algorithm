package 백준.java.algorithm.greedy;

import java.util.*;
import java.io.IOException;

class AtoB {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();    //2
        int b = sc.nextInt();    //162
        int count = 1;

        while(a < b){
            if(b % 2 == 0){        //2의 약수인 경우
                count++;
                b /= 2;
                continue;
            }
            String bStr = Integer.toString(b);
            if(bStr.charAt(bStr.length()-1) == '1'){        // 끝 자리가 1인 경우
                count++;
                b = Integer.parseInt(bStr.substring(0, bStr.length()-1));
            }else{
                count = -1;
                break;
            }
        }
        if(a != b) System.out.println(-1);
        else System.out.println(count);

    }
}
