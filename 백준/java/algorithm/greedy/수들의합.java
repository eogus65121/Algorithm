package 백준.java.algorithm.greedy;

import java.io.*;

public class 수들의합 {

    public class Main {
        // 성적이 하나라도 좋아야한다, 서류심사와 면점심사 2가지가 있다
        // 신입 사원 최대 입사 수
        public void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long s = Long.valueOf(br.readLine());
            long sum = 0;
            long answer = 1;
            while(true){
                if(sum + answer <= s){
                    sum += answer;
                    answer++;
                }
                else{
                    break;
                }
            }
            System.out.println(answer-1);
        }
    }

}
