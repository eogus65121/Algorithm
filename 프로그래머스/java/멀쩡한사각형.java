class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = gcf(w, h);
        answer = ((long)w*(long)h) - (long)(w+h-gcd);
        return answer;
    }

    private int gcf(int num1, int num2){
        int min = (num1 < num2) ? num1 : num2;
        int gcd = 0;
        for(int i = 1; i <= min; i++){
            if(num1 % i == 0 && num2 % i == 0) gcd = i;
        }
        return gcd;
    }
}

/*
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        if(w > h){
            int temp = w;
            w = h;
            h = temp;
        }
        int gcd = gcf(w, h);
        double d_w = w/gcd, d_h = h/gcd;
        long r_box = (long)Math.ceil((d_h/d_w)); // 한 칸에 제거가 되는 박스의 개수
        answer = ((long)w*(long)h) - (long)(r_box * d_w * gcd); >> 이놈에 대한 예외처리??
        return answer;
    }

    private int gcf(int num1, int num2){
        int min = (num1 < num2) ? num1 : num2;
        int gcd = 0;
        for(int i = 1; i <= min; i++){
            if(num1 % i == 0 && num2 % i == 0) gcd = i;
        }
        return gcd;
    }
}
*/