import java.util.*;
class Solution {
    
    public int solution(int[][] jobs) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.useTime==b.useTime){
                return Integer.compare(a.requestTime, b.requestTime);
            } 
            return Integer.compare(a.useTime, b.useTime);
        });
        Arrays.sort(jobs , (a,b) -> a[0]-b[0]);

        int answer = 0;
        int now = jobs[0][0];
        int i = 0;
        int process = jobs.length;

        while(!pq.isEmpty() || i<process){
            //now를 기준으로 pq업데이트
            while(i!=process && jobs[i][0]<=now){
                int requestTime = jobs[i][0];
                int useTime = jobs[i][1];
                Pair pair1 = new Pair(requestTime, useTime);
                pq.add(pair1);
                i++;
            }
            if(pq.isEmpty()){
                now = jobs[i][0];
                continue;
            }
            //지금 상태가 usable이므로
            Pair pair = pq.peek();
            now+=pair.useTime; // 걸리는 시간만큼 뒤로 보낸다
            answer= answer + now - pair.requestTime; // 최종 반환 시간 - 요청 시간 반영
            pq.remove();
        }
        answer/=process; //평균
        return answer; 
    }
    public static class Pair{
        int requestTime;
        int useTime;
        Pair(int requestTime, int useTime){
            this.requestTime = requestTime;
            this.useTime = useTime;
        }
    }
}

