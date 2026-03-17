import java.util.*;

public class Main {
    static int n;
    static List<List<Node>> m = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i =0; i<n;++i){
            m.add(new ArrayList<>());
        }

        for(int i =0; i<n-1;++i){
            int a = sc.nextInt()-1;
            int b = sc.nextInt() - 1;
            int val = sc.nextInt();

            m.get(a).add(new Node(b, val));
            m.get(b).add(new Node(a, val));
        }

        DFS(0,-1);
        System.out.println(answer);
    }

    static int DFS(int now, int parent) {
        int ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1,o2) -> o2-o1
        );
        pq.add(0);
        pq.add(0);
        for(int i =0; i<m.get(now).size(); ++i) {
            int next = m.get(now).get(i).a;
            int nextVal = m.get(now).get(i).val;

            if(next == parent) {
                continue;
            }
            int tmp = DFS(next, now) + nextVal;
            
            pq.add(tmp);

        }
        ans += pq.poll();
        int returnVal = ans;
        ans += pq.poll();

        answer = Math.max(answer, ans);
        return returnVal;
    }

    static class Node {
        int a;
        int val;

        Node (int a, int val) {
            this.a = a;
            this.val = val;
        }
    }

}