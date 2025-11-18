import java.util.*;

public class Main {

    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {1,1,1,0,-1,-1,-1,0};
    static HashMap<Long, Integer> m = new HashMap<>();


    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

       Park[] arr = new Park[n];

       for(int i =0; i<n;++i){
          int a = sc.nextInt();
          int b = sc.nextInt();
          int c = sc.nextInt();
          c--;

          arr[i] = new Park(a,b,c);
       }

       int ans = 0;
       int t = 100000000;

       for(int i =0; i<n;++i){
          m.clear();
          for(int j = i+1; j<n;++j) {
             meet(arr[i], arr[j]);
          }

          for(Long key : m.keySet()) {
              int cnt = m.get(key) + 1;
              int kt = (int)(key & 0xFFFFF);
              if(cnt > ans) {
                 ans = cnt;
                 t= kt;
              }
              else if(cnt == ans) {
                 t = Math.min(t, kt);
              }
          }

       }

       System.out.println(ans);
       System.out.println(t);
    }

    static int reverse(int dir) {
       return (dir + 4) % 8;
    }

    static void meet(Park a, Park b) {
       int x = b.x - a.x;
       int y = b.y - a.y;
       int ddx = dx[b.dir] + dx[reverse(a.dir)];
       int ddy = dy[b.dir] + dy[reverse(a.dir)];

       if(ddx == 0 && ddy == 0) {
          return;
       } else if(ddx != 0 && ddy !=0) {
          if(x%ddx == 0 && y%ddy ==0) {
             int tx = x/ddx;
             int ty = y/ddy;
             if(tx == ty && x * ddx <0 && y * ddy<0) {
                int nx = a.x + dx[a.dir] * Math.abs(tx);
                int ny = a.y + dy[a.dir] * Math.abs(tx);
                int nt = Math.abs(tx);
                long hash = ((long)(nx+100000) << 40) | ((long)(ny+100000) << 20) | nt;
                m.put(hash, m.getOrDefault(hash, 0)+1);
             }
          }
       } else if(ddx ==0 && x==0 && y%ddy==0&& y * ddy <0) {
          int nt = Math.abs(y/ddy);
          int nx = a.x + dx[a.dir] * nt;
          int ny = a.y + dy[a.dir] * nt;
          long hash = ((long)(nx+100000) << 40) | ((long)(ny+100000) << 20) | nt;
          m.put(hash, m.getOrDefault(hash, 0)+1);
       } else if(ddy ==0 && y==0 && x%ddx==0 && x * ddx <0) {
          int nt = Math.abs(x/ddx);
          int nx = a.x + dx[a.dir] * nt;
          int ny = a.y + dy[a.dir] * nt;
          long hash = ((long)(nx+100000) << 40) | ((long)(ny+100000) << 20) | nt;
          m.put(hash, m.getOrDefault(hash, 0)+1);
       }
    }

    static class Park{
       int x;
       int y;
       int dir;

       public Park(int x, int y, int dir) {
          this.x = x;
          this.y = y;
          this.dir = dir;
       }
    }
}