import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<Cache> list =new ArrayList<>();
        int now = 0;

        //cities 돌면서 
        for(String city : cities){
            city = city.toUpperCase(); //대소문자 구분 X
            int hit = findCache(list, city); 
            
            //miss인 경우: 추가, 넘치면 삭제
            if(hit==-1){
                list.add(new Cache(now, city));
                if(list.size()>cacheSize){
                    list.remove(list.get(0));
                }
                now+=5;
            }
            //hit인 경우: hitTime 업데이트 
            else{
                list.remove(list.get(hit));
                list.add(new Cache(now,city));
                now+=1;
            }
        }
        
        return now;
    }
    
    private static class Cache{
        int hitTime;
        String value;
        
        public Cache(int hitTime, String value){
            this.hitTime = hitTime;
            this.value = value;
        }
    }
    private static int findCache(List<Cache>list, String city){
        for(int i=0;i<list.size();i++){
            if(list.get(i).value.equals(city)){
                return i;
            }
        }
        return -1;
    }
}