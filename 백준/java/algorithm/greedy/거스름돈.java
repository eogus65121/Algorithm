package 백준.java.algorithm.greedy;

public class 거스름돈 {
    public class main{
        // 거스름 돈의 금액 X, 개수를 가장 적게 잔돈을 준다
        // 1000엔을 낸 경우, 잔돈에 포함된 잔돈의 개수를 구하는 프로그램
        public void main(String[] args) {
            int[] bill = {500, 100, 50, 10, 5, 1};
            int remainBill = 1000-1;
            int answer = 0;
            while(true){
                if(remainBill == 0) break;
                for(int i = 0; i < bill.length; i++){
                    if(remainBill >= bill[i]){
                        answer += remainBill / bill[i];
                        remainBill -= bill[i] * (remainBill/bill[i]);
                        break;
                    }else continue;
                }
            }
            System.out.println(answer);
        }
    }

    // 더 빠른 풀이
////    import java.io.*;
//import java.util.*;
//
//    class Main{
//        public static void main(String[] args) throws IOException{
//            Scanner sc = new Scanner(System.in);
//            int num = sc.nextInt();
//            int count = 0;
//            int n = num / 5;
//            while(true){
//                if(n < 0){
//                    count = -1;
//                    break;
//                }
//                int left = num - (5 * n);
//                if(left % 2 == 0){
//                    count += (left/2) + n;
//                    break;
//                }
//                n--;
//            }
//            System.out.println(count);
//        }
//    }
}
