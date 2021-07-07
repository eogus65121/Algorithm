package 프로그래머스.java;

public class 스킬트리 {
    class Solution {  
        public int solution(String skill, String[] skill_trees) {  
              int answer = 0;
              for(int skillTrees_i=0; skillTrees_i<skill_trees.length; skillTrees_i++){
                  int skillIndex=0;
                  boolean flag = true;
        
                  for(int skillTreesArray_j=0; skillTreesArray_j<skill_trees[skillTrees_i].length(); skillTreesArray_j++){
                      for(int skill_k=skillIndex; skill_k<skill.length(); skill_k++){
                          if(skill.charAt(skill_k) == skill_trees[skillTrees_i].charAt(skillTreesArray_j)){
                              if(skill_k!=skillIndex){
                                  flag = false;
                              }else{
                                  skillIndex++;
                              }
                          }
                      }
                  }
                  if(flag == true){
                      answer ++;
                  }
              }
              return answer;
            }
        }
}
