import java.util.*;
import java.util.stream.*;
class Solution {
    int dx[] = {0, 1, 0, -1};
    int dy[] = {-1, 0, 1, 0};
    boolean[][]visited;
    List<Integer>foods; 
    public int[] solution(String[] maps) {
        //하나의 group에 있는 식량 모두 더하기 
        //그리고 그걸 오름차순으로 담아서 리턴하기 
        //그러면 ArrayList에 담아서 다시 배열로 변환해서 주면 되겠당 
        int n = maps.length;
        int m = maps[0].length();
        visited = new boolean[n][m];
        foods = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    String s = maps[i].substring(j,j+1);
                    if(s.equals("X")){
                        continue;
                    }else{
                       bfs(j, i, n, m, maps); 
                    }
                }
            }
        }
        if(foods.size()==0){
            return new int[]{-1};
        }
        int[] answer = foods.stream().mapToInt(Integer::intValue).sorted()
                    .toArray();
        
        return answer;
    }
    public void bfs(int x, int y, int n, int m, String[]maps){
        Queue<Coord>q = new LinkedList<>();
        visited[y][x]=true;
        q.offer(new Coord(x,y));

        int food = 0;
        
        while(!q.isEmpty()){
            Coord c = q.poll();
            x = c.x; 
            y = c.y;
            food+=Integer.valueOf(maps[y].substring(x,x+1));
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[ny][nx]){
                    if(maps[ny].substring(nx,nx+1).equals("X")){
                        continue;
                    }
                    visited[ny][nx]=true;
                    q.offer(new Coord(nx, ny));
                }
            }
        }
        foods.add(food);
    }
    public class Coord{
        int x;
        int y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}