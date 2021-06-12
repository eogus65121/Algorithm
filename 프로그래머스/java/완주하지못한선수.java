package 프로그래머스.java;
import java.util.Map;
import java.util.HashMap;

public class 완주하지못한선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> hash = new HashMap<>();
            
            for(String str : participant){
                hash.put(str, hash.getOrDefault(str, 0) +1);
            }
            for(String str : completion){
                hash.put(str, hash.get(str) -1);
            }
            for(String key : hash.keySet()) {
                if(hash.get(key)!= 0 ) {
                    return key;
                }
            }
            return null;
        }
    }
}
