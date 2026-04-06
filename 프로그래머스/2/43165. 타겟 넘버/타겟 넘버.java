import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        //bottom up 
            // 앞에서부터 +-로 가능한 경우의 수를 계산 -> 그 값들 +- 지금 값을 저장,
            // Map의 key: 지금까지 계산한 값, value: 경우의 수 
        
        Map<Integer,Integer> cnt = new HashMap<>();
        cnt.put(numbers[0],1);
        cnt.put(-numbers[0],1);
        
        for(int i=1;i<numbers.length;i++){
            Map<Integer,Integer> next_cnt = new HashMap<>();
            for(int last:cnt.keySet()){
                int left_key = last-numbers[i];
                int right_key = last+numbers[i];
                next_cnt.put(right_key, next_cnt.getOrDefault(right_key,0) + cnt.get(last));
                next_cnt.put(left_key, next_cnt.getOrDefault(left_key,0) + cnt.get(last));     
            }
            cnt = next_cnt;
        }
        
        return cnt.get(target);
    }
    
   
}