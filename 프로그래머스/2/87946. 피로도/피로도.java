import java.util.*;
class Solution {
    int maxDepth = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        Arrays.fill(visited,false);
        dfs(dungeons, 0, k, 0, visited);
        return maxDepth;
    }
    public void dfs(int[][] dungeons, int i, int xp, int depth, boolean[] visited){
        maxDepth = Math.max(maxDepth, depth);
        
        for(int j=0;j<dungeons.length;j++){
            if(!visited[j]&&dungeons[j][0]<=xp){
                visited[j]=true;
                dfs(dungeons, j+1, xp-dungeons[j][1], depth+1, visited);
                visited[j]=false;
            }
        }
        return;
    }
}