import java.util.Arrays;
import java.util.TreeMap;

public class 위클리챌린지4주차 {

class Solution {
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i = 0; i < table.length; i ++){
            int value = 0;
            for(int j = 0; j < languages.length; j++){
								//배열을 list형태로 만드는 코드 and 원하는 값이 포함하는지 boolean값으로 확인
                if(Arrays.asList(table[i].split(" ")).contains(languages[j])){
									//list 형태로 만든 array에서 원하는 값의 index를 뽑아내고 계산
                    value += (6 - Arrays.asList(table[i].split(" ")).indexOf(languages[j])) * preference[j];
                }
            }
						//table[i].split(" ")[0] == 직군, value는 점수
            map.put(table[i].split(" ")[0], value);
        }
        int size = 0;
        for(String s : map.keySet()){
            if(size < map.get(s)) {
                answer = s;
                size = map.get(s);
            }
        }
        return answer;
    }
}
}
