import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int cnt = 0;
        String format = "HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        PriorityQueue<LocalTime> now = new PriorityQueue<>();

        //start time을 기준으로 정렬
        Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));
        
        for (String[] book : book_time){
            //end에 10분 청소시간 더해서 저장하기 
            LocalTime startTime = LocalTime.parse(book[0], formatter);
            LocalTime endTime = LocalTime.parse(book[1], formatter);
            
            //endTime -> priority queue에 넣고, startTime보다 작거나 같은 값이 있다면 remove하기 
            while(!now.isEmpty()){
                LocalTime lastEnd = now.peek();
                if(lastEnd.isAfter(LocalTime.parse("23:49",formatter))){
                    break;
                }
                lastEnd=lastEnd.plusMinutes(10);
                if(lastEnd.isBefore(startTime)||lastEnd.equals(startTime)){
                    now.remove();
                }else{
                    break;
                }
            }
            //endTime 넣기 
            now.add(endTime);
            
            //방 개수 업데이트 
            cnt = Math.max(cnt, now.size());            
        }
        
        return cnt;
    }
}