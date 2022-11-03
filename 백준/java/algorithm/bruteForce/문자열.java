package 백준.java.algorithm.bruteForce;
import java.io.*;
import java.util.*;

public class 문자열 {

    public class Main{
        public  void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            String str1 = str[0];
            String str2 = str[1];
            int endPoint = str2.length();
            int startPoint = 0;
            int cnt = 0;
            while(startPoint + str1.length() <= endPoint){
                cnt  = Math.max(cnt, compStr(str1, str2.substring(startPoint, startPoint + str1.length())));
                startPoint++;
            }
            System.out.print(str1.length() - cnt);
        }
        private  int compStr(String str1, String str2){
            int rtnCnt = 0;
            for(int i = 0; i < str1.length(); i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    rtnCnt++;
                }
            }
            return rtnCnt;
        }
    }
}
