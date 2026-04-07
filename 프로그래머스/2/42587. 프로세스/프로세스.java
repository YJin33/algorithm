import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] priorities, int location) {

        List<Integer> desc_val = Arrays.stream(priorities)
                                .boxed() 
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());
        
        Queue<Pair> q = new LinkedList<>(); 

        for(int i=0;i<priorities.length;i++){
            q.add(new Pair(i,priorities[i]));
        }
        
        int now = 1;
        while(!q.isEmpty()){
            int max_priority = desc_val.get(now-1);
            if(max_priority == q.peek().priority){
                if(q.peek().index==location){
                    return now;
                }
                now++;
                q.remove();
                
            }else{
                q.add(q.peek());
                q.remove();
            }
        }

        return now;
    }
    public class Pair{
        int index;
        int priority;
        
        public Pair(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
}