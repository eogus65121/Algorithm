package 백준.java.algorithm.greedy;

import java.util.*;
import java.io.IOException;

class 동전0 {

    public static void main(String[] args) throws IOException{
        // 동전의 종류 n
        // k원을 만드는데 필요한 동전 개수의 최솟값
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int money = sc.nextInt();
        int answer = 0;
        List<Integer> moneyList = new ArrayList<>();
        for(int i = 0; i < k; i++) moneyList.add(sc.nextInt());

        Collections.sort(moneyList, Collections.reverseOrder());

        for(int i = 0; i < moneyList.size(); i++){
            if(money == 0) break;
            if(money / moneyList.get(i) > 0){
                int num = money / moneyList.get(i);
                money -= moneyList.get(i) * num;
                answer += num;
            }
        }
        System.out.print(answer);
    }

}
