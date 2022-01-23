import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>(); // 신고한 사람의 이름
        Set<String> hs = new HashSet<>();
        for (String s : report) hs.add(s); // 신고 중복 제거
        Iterator<String> it = hs.iterator();

        while (it.hasNext()) {
            String[] s_split = it.next().split(" ");
            if(map.containsKey(s_split[1])){
                List list = map.get(s_split[1]);
                list.add(s_split[0]);
                map.put(s_split[1], list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s_split[0]);
                map.put(s_split[1], list);
            }
        }
        for(int i = 0; i < id_list.length; i++){
            if(!map.containsKey(id_list[i])) continue;
            if(map.get(id_list[i]).size() >= k){
                List list = map.get(id_list[i]);
                for(int j = 0; j < list.size(); j++){
                    for(int index = 0; index < id_list.length; index++){
                        if(id_list[index].equals(list.get(j))){
                            answer[index]++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}

/** stream을 활용한 코드
 import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
 * 
 */

 /** 객체 지향을 활용한 코드
  * 
  import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }

        for(String re : report){
            String[] str = re.split(" ");
            //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }

        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }

         for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){
                     answer[idIdx.get(user.name)]++;
                 }

             }
        }




        return answer;
    }
}

class User{
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}
  * 
  */