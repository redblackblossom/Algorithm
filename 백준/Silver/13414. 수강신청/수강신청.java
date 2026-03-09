import java.util.*;

public class Main {
    static int K;
    static int L;
    static int cnt = 0;
    static Map<String, Integer> m = new HashMap<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp;

        K = sc.nextInt();
        L = sc.nextInt();
        sc.nextLine();
        for(int i =0; i<L;++i) {
            tmp = sc.nextLine();
            m.put(tmp, cnt);
            cnt++;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2) -> o1.idx - o2.idx
        );

        for(String s : m.keySet()) {
            pq.add(new Node (s, m.get(s)));
        }

        while(K --> 0) {
            if(pq.isEmpty()){
                break;
            }
            Node top = pq.poll();

            System.out.println(top.num);
        }

    }

    static class Node {
        String num;
        int idx;

        Node(String a, int b) {
            num = a;
            idx = b;
        }
    }
}