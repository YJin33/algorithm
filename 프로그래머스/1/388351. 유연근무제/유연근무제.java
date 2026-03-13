class Solution {    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

       //월화수목금만 성공하면 됨 
        for(int i=0;i<schedules.length;i++){
            int rightTime = plusTenMinutes(schedules[i]); //i번째 목표 출근
            for(int j=0;j<7;j++){
                //startDay +알파로 계산
                int day = (startday+j-1)%7;
                if(day<5 && rightTime<timelogs[i][j]){ //평일이고 시간을 안지켰다면 
                    break;
                }
                if(j==6){ //마지막까지 성공했다면
                    answer++;
                }
            }
        }
        
        return answer;
        
    }
     private int plusTenMinutes(int now){
        now+=10;
        int min = now%100;
        int hour = now/100;
        if(now%100>=60){
            hour++;
            min-=60;
            now = hour*100 + min;
            return now;
        }else{
            return now;
        }
    }
    
}