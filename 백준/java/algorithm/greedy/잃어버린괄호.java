package 백준.java.algorithm.greedy;
import java.util.*;
import java.io.*;

public class 잃어버린괄호 {

    public class Main {
        public void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int answer = 0;
            String[] split1 = str.split("-");
            for (int i = 0; i < split1.length; i++) {
                int num = 0;
                StringTokenizer st = new StringTokenizer(split1[i], "+");
                while (st.hasMoreTokens()) {
                    num += Integer.parseInt(st.nextToken());
                }
                if (i != 0) answer -= (num);
                else answer += num;
            }
            System.out.println(answer);
        }
    }
}
