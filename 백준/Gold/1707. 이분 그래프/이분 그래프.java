import java.util.*;

public class Main
{
    static int k;
    static int v;
    static int e;

    static List<List<Integer>> m;
    static int[] color;
    static String ans = "YES";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        while(k-->0) {
            v = sc.nextInt();
            e = sc.nextInt();
            if(v==0){
                System.out.println("YES");
                continue;
            }
            color = new int[v];
            m = new ArrayList<>();
            ans = "YES";

            for(int i =0; i<v;++i){
                m.add(new ArrayList<>());
            }

            for(int i =0; i<e;++i){
                int a = sc.nextInt();
                int b = sc.nextInt();
                a--;
                b--;
                m.get(a).add(b);
                m.get(b).add(a);
            }
            for(int i =0; i<v;++i){
                if(color[i]==0){
                    DFS(i);
                }
            }

            System.out.println(ans);
        }

    }



    static void DFS(int now){

        List<Integer> tm = m.get(now);

        for(int next : tm) {
            if(color[next] == 0){
                if(color[now] ==1) {
                    color[next] =2;
                } else {
                    color[next] = 1;
                }
                DFS(next);

            } else{
                if(color[now] == color[next]){
                    ans = "NO";
                    return;
                }
            }
        }
    }
}