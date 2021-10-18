import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        
        if(cacheSize == 0) return 5*cities.length;
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            if(list.contains(city)){
                list.remove(city);
                list.addFirst(city);
                answer+=1;
            }else{
                if(list.size() < cacheSize){
                    list.addFirst(city);
                    answer += 5;
                }else{
                    list.removeLast();
                    list.addFirst(city);
                    answer+= 5;
                }
            }
        }
        return answer;
    }
}