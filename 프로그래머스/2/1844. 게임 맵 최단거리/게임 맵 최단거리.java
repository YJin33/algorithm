import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        //하 우 상 좌 
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        int m = maps.length;
        int n = maps[0].length;
        
        Queue<Coordinate>q = new LinkedList<>();
        boolean[][] visited= new boolean[m][n];
        q.offer(new Coordinate(0,0,0));
        visited[0][0] = true;
        if(maps[m-1][n-1]==0){return -1;}
        
        while(!q.isEmpty()){
            Coordinate c = q.poll();
            int d = c.d;
            int x = c.x;
            int y = c.y;
            if(x==n-1 && y==m-1){
                return d+1;
            }
            for(int i=0;i<4;i++){//상하좌우
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m &&maps[ny][nx]==1 &&!visited[ny][nx] ){
                    q.offer(new Coordinate(nx,ny, d+1));
                    visited[ny][nx]=true;
                }
            }
        }

        return -1;
    }
    public class Coordinate{
        int x;
        int y;
        int d;//이 전까지 distance
        public Coordinate(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}