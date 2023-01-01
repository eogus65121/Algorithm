package 알고리즘;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        //
    }

    // 최대공약수
    private int gcd(int n, int m){
        if(m == 0) return n;
        return gcd(m, n%m);
    }
}
