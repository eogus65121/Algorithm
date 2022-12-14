package 알고리즘;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    // 방문 노드 메모라이징
    static List<Integer> rtnList = new ArrayList<>();

    public static void main(String[] args) {
        boolean[] vst = new boolean[9];

        // 그래프 연결 상태를 2차원 배열로 표현
        // 인덱스는 각각의 노드 번호이며 0번 인덱스는 없음
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        // dfs 실행
        dfs(vst, graph);

        // 결과 출력
        rtnList.stream().forEach(System.out::println);
    }

    // 한가지 정점과 모든 정점을 탐색하는 경우 스택을 활용한 dfs
    public static  void dfs(boolean[] vst, int[][] graph){
        Stack<Integer> stack = new Stack<>();

        // 시작 전 시작 노드 넣기 (1번 노드로 시작), 방문 처리
        stack.push(1);
        vst[1] = true;

        while(!stack.isEmpty()){
            int nodeIdx = stack.pop();
            rtnList.add(nodeIdx);

            for(int linkedNode : graph[nodeIdx]){
                if(!vst[linkedNode]){
                    stack.push(linkedNode);
                    vst[linkedNode] = true;
                }
            }
        }

    }

    // 한 가지 정점과 모든 정점을 탐색하는 경우 재귀를 활용한 dfs
    public static void dfs1(int[][] graph, int nodeIdx, boolean[] vst){
        vst[nodeIdx] = true;
        rtnList.add(nodeIdx);

        for(int node : graph[nodeIdx]){
            if(!vst[node]){
                dfs1(graph, node, vst);
            }
        }
    }

    //경로를 찾아야하는 경우 dfs
    public static void dfs2(int[][] graph, int nodeIdx, boolean[] vst){
        for(int node : graph[nodeIdx]){
            if(vst[node] == true) continue;

            //false
            vst[node] = true;
            dfs2(graph, nodeIdx, vst);
            vst[node] = false;
        }
    }

    //todo 사이클이 존재하는 경우의 dfs 알고리즘 변형 추가 예정
}
