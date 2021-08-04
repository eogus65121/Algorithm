import java.util.ArrayList;
public class 거리두기확인하기 {
    class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int [5];
            for(int i = 0; i < 5; i++){
                String[][] temp = array_split(places[i]);
                answer[i] = distance_value(temp);
            }
            return answer;
        }

        // places의 String 값을 split으로 2차원 배열 하나하나로 쪼갬
        // places[i] = "POOOP"  >> place[i][j] = {P, O, O, O, P} 이런식
        String [][] array_split(String [] place){
            String [][] arr = new String[5][5];
            for(int i = 0; i < 5; i++){
                int index = 0;
                for(String j : place[i].split("")) arr[i][index++] = j;
            }
            return arr;
        }

        int distance_value(String [][] place){
            ArrayList<Integer> list = coordinate(place); // P의 좌표를 가져오기

            // P가 없는경우 무조건 참 1을 return
            if(list.size() == 0) return 1;

            for(int i = 0; i < list.size()-2; i+=2){  // x축 y축 2개가 입력되어 있으므로 i는 2씩 증가
                int x1 = list.get(i);
                int y1 = list.get(i+1);
                for(int j = i+2; j < list.size(); j+=2){ // 이것 역시 2씩 증가
                    int x2 = list.get(j);
                    int y2 = list.get(j+1);
                    int distance_abs = Math.abs(x1-x2) + Math.abs(y1-y2);  // P끼리의 거리 계산
                    if(distance_abs < 3){ // P의 거리가 2이하면 if문 입장 3가지 종류
                        if(x1 == x2){  // x는 같고 y가 다를때
                            if(!place[x1][(y1+y2)/2].equals("X")) return 0;
                        }
                        else if(y1 == y2){ // x가 다르고 y는 같을때
                            if(!place[(x1+x2)/2][y1].equals("X")) return 0;
                        }  // x 와 y가 모두 다를때
                        else if(!place[x1][y2].equals("X") || !place[x2][y1].equals("X")) return 0;
                    }
                }
            }
            // 해당되는 조건이 없을경우 참 return 1
            return 1;
        }
        // array_2d return 받은 값에서 P의 좌표를 list에 저장 // 추후 P를 기준으로 값을 비교
        ArrayList<Integer> coordinate(String[][] arr){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(arr[i][j].equals("P")){
                        list.add(i); // x축
                        list.add(j); // y축
                    }
                }
            }
            return list;
        }
    }
}
