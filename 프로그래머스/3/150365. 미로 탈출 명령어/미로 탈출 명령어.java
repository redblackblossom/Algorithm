import java.util.*;

class Solution {
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static int[] dc = {0,1,2,3};
    static String[] dddc = {"d", "l", "r", "u"} ;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int[][][] dp = new int[n][m][k+1];
        x--;
        y--;
        r--;
        c--;
        
        Deque<Node> dq = new ArrayDeque<>();
        for(int i =0; i<n;++i){
            for(int j =0; j<m;++j){
                for(int u =0; u<=k;++u){
                    dp[i][j][u] = -1;
                }
            }
        }
        
        dq.addLast(new Node(x,y,0));
        dp[x][y][0] = 0;
        
        while(!dq.isEmpty()) {
            Node now = dq.pollFirst();
            if(dp[r][c][k] != -1) break;
            
            for(int i =0; i<4;++i){
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];
                int llen = now.len+1;
                
                if(xx <0 || xx >=n || yy <0 || yy>=m) continue;
                if(llen > k) continue;
                
                if(dp[xx][yy][llen] == -1) {
                    dp[xx][yy][llen] = dc[i];
                    dq.addLast(new Node(xx,yy,llen));
                }
            }
            
        }
        
        if(dp[r][c][k] != -1) {
            answer = rollback(dp,x,y,r,c,k);
        } else {
            answer = "impossible";
        }
        
        
        return answer;
    }
    
    class Node {
        int x;
        int y;
        int len;
        
        Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.len = s;
        }
    }
    
    String rollback(int[][][] dp, int x, int y, int r, int c, int k) {
        List<Integer> list = new ArrayList<>();
        int nx = r;
        int ny = c;
        while(true){
            if(nx == -1 || ny == -1 || k ==-1) break;
            
            if(nx == x && ny == y && k == 0){
                break;
            }
            int ddir = dp[nx][ny][k];
            
            
            list.add(dc[ddir]);
            nx = nx - dx[ddir];
            ny = ny - dy[ddir];
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =list.size()-1; i>=0; --i){
            sb.append(dddc[list.get(i)]);
        }
        
        return sb.toString();
    }
}