class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t*m; i++){
            sb.append(conversion(i, n));
        }
        String str = sb.toString().toUpperCase();
        sb.setLength(0);
        for(int i = p-1; i < str.length(); i+=m){
            sb.append(str.charAt(i));
            if(sb.length() == t) break;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    private String conversion(int num, int n){
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int current = num;
        while(current > 0){
            if(current % n < 10){
                sb.append(current % n);
            }else{
                sb.append((char)(current % n - 10 + 'A'));
            }
            current /= n;
        }
        return sb.reverse().toString();
    }
}