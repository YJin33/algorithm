class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        //상 우 하 좌
        int[]dx={0,1,0,-1};
        int[]dy={-1,0,1,0};

        int[] answer = new int[queries.length];
        int[][] box = new int[rows+1][columns+1];
        
        //box 채우기
        for(int i=1;i<=rows; i++){
            for(int j=1;j<=columns; j++){
                box[i][j]=(i-1) * columns + j;
            }
        }
        
        //query 실행 
        int idx=0;
        for(int[]query : queries){
            //컨테이너를 x1 x2 y1 y2 범위로 두고, 역방향에서 벽에 부딪힌다면 방향을 --
            //다음 값을 나에게 저장하는 식
            //그러면 start 값을 저장해두어야 함!(첫번째로 날라가는 값)
            
            //query: x1 y1 x2 y2인데 이문제는 x y 반대
            int y1=query[0], y2=query[2],
                x1=query[1], x2=query[3];
            
            int j=x1, i=y1, next_i=0, next_j=0;
            int startValue = box[i][j];
            int minValue = box[i][j];
            int d = 2; //시작점에서 내려가는 걸로 시작 
            while(!(next_i==y1 && next_j==x1)){
                next_i=i+dy[d];
                next_j=j+dx[d];
                
                // 값을 가져올 애가 box 밖에 있다면 
                if(next_i<y1|| next_i>y2 || next_j<x1 || next_j>x2){
                    d=(d+3)%4;
                    next_i=i+dy[d];
                    next_j=j+dx[d];
                }
               
                //아니라면 
                box[i][j]=(box[next_i][next_j]); //업데이트
                
                minValue = Math.min(minValue,box[i][j]);
                i=next_i;
                j=next_j;
            }
            // box[y1][x1]의 넥스트에 startValue 대입 
            box[y1][x1+1]=startValue;
            answer[idx]=minValue;
            idx++;            
        }
        
        return answer;
    }
}