import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String>str1_list = new ArrayList<>();
        List<String>str2_list = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String[] str = {str1, str2};
        
        for(int j = 0; j < str.length; j++){
            for(int i = 0; i < str[j].length()-1; i++){
                String temp = "";
                if(j == 0) temp = str1.substring(i, i+2).replaceAll("[^a-zA-Z]", "");
                else temp = str2.substring(i, i+2).replaceAll("[^a-zA-Z]", "");
                if(temp.length() == 2 && j == 0) str1_list.add(temp);
                if(temp.length() == 2 && j == 1) str2_list.add(temp);
            }
        }
        
        if(str1_list.size() == 0 && str2_list.size() == 0) return 65536;
        
        double common = 0, sum = 0;
        for(int i = 0; i < str1_list.size(); i++){
            if(str1_list.indexOf(str1_list.get(i)) < i) continue;
            int cnt1 = Collections.frequency(str1_list, str1_list.get(i));
            int cnt2 = Collections.frequency(str2_list, str1_list.get(i));
            common += Math.min(cnt1, cnt2);
            sum += Math.max(cnt1, cnt2);
        }
        
        for(int i = 0; i < str2_list.size(); i++){
            if(!str1_list.contains(str2_list.get(i))) sum += 1;
        }
        if(common == 0) return 0;
        if(sum == 0) return 65536;
        
        double cal = common/sum*65536;
        answer = (int)cal;
        
        return answer;
    }
}