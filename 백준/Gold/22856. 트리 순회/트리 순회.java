import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> m = new ArrayList<>();
    static int[] parents;
    static int[] ch;
    static int acc = 0;
    static int ans = 0;
    static int last;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         N = sc.nextInt();
         ch = new int[N];
         parents = new int[N];
         for(int i =0; i<N;++i) {
            m.add(new ArrayList<>());
         }


        parents[0] =-1;
         for(int i =0; i<N;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;b--;c--;

            m.get(a).add(b);
            m.get(a).add(c);
            if(b != -2){
                parents[b] = a;
            }

            if(c != -2){
                parents[c] = a;
            }
         }

         ch[0] = 1;
         parents[0] = -2;
         acc++;

         findLast();

         DFS(0,-2);
         System.out.print(ans);
    }

    static void DFS(int v, int parent) {
        int left = m.get(v).get(0);
        int right = m.get(v).get(1);
        if(left != -2 && ch[left] ==0){
            ch[left] = 1;
            acc++;
            DFS(left, v);
            ans++;
        } 
        else if(right != -2 && ch[right] ==0) {
            ch[right] =1;
            acc++;
            DFS(right, v);
            ans++;
        }
        else if(last == v){
            return;
            
        }
        else if(parent != -2){
            ans++;
            DFS(parent, parents[parent]);
        }
    }



    static void findLast() {
        int cur = 0;
        while(true) {
            int right = m.get(cur).get(1);
            if(right == -2) break;
            cur = right;
        }
        last = cur;
    }
}