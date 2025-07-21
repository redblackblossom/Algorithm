import java.util.*;

public class Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
    	 Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int val = sc.nextInt();
         int arr[][] = new int[n][n];
         int[] dx = {1,0,-1,0};
         int[] dy = {0,1,0,-1};
         int x = 0;
         int y = 0;
         int dir = 0;
          
         for(int i=n*n; i>0 ;--i) {
             arr[x][y] = i;
             int xx = x + dx[dir];
             int yy = y + dy[dir];
              
             if(xx<0 || yy<0 || xx >=n || yy >=n || arr[xx][yy] !=0){
                 xx = xx - dx[dir];
                 yy = yy - dy[dir];
                 dir++;
                 if(dir==4){
                     dir = 0;
                 }
                  xx = x + dx[dir];
                  yy = y + dy[dir];
             }
              
             x = xx;
             y = yy;
         }
         StringBuilder sb = new StringBuilder();

      for (int i = 0; i < n; ++i) {
          for (int j = 0; j < n; ++j) {
              sb.append(arr[i][j]).append(' ');
          }
          sb.append('\n');
      }


      outer:
      for (int i = 0; i < n; ++i) {
          for (int j = 0; j < n; ++j) {
              if (arr[i][j] == val) {
                  sb.append(i + 1).append(' ').append(j + 1);
                  break outer;
              }
          }
      }

      System.out.print(sb);

         
    }
    
}
