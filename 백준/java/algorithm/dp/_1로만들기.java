package 백준.java.algorithm.dp;

import java.io.*;

public class _1로만들기 {

     class Main {
         int answer  = Integer.MAX_VALUE;

        public void main(int n, int cnt){
            if(n == 1) {
                answer = Math.min(answer, cnt);
                return;
            }

            if(answer <= cnt) return;

            if(n % 3 == 0){
                main(n/3, cnt+1);
            }if(n%2 == 0){
                main(n/2, cnt+1);
            }
            main(n-1, cnt+1);
        }
        public void main(String[] args) throws IOException {
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.parseInt(br.readLine());
                main(n, 0);
                System.out.print(answer);
            }
        }
    }
}
