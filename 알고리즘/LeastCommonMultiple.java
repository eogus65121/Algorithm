package 알고리즘;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        int n = 10;
        int m = 20;

        // n * m / gcd = 최소공배수
        int lcm = n * m / gcd(n, m);

    }

    // 최대공약수
    private static int gcd(int n, int m){
        if(m == 0) return n;
        return gcd(m, n%m);
    }
}
