package 백준.java.algorithm.dp;

import java.io.*;

public class 설탕배달 {

    public class Main{
        int answer = 0;

        public void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            main(n);
            System.out.print(answer);
        }

        public void main(int n){
            if(n == 0) return;
            if(n%5 != 0 && n%3 != 0){
                if(n > 5){
                    answer++;
                    main(n-5);
                }else{
                    answer = -1;
                    return;
                }
            }
            if(n%5 == 0){
                answer++;
                main(n-5);
            }else if(n%3 == 0){
                answer++;
                main(n-3);
            }
        }
    }
}
