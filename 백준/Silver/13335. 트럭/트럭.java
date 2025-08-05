import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Node> dq = new ArrayDeque<>();

        int now = 1;
        int idx =0;
        int acc = 0;
        while(true) {
            if(dq.isEmpty() && idx == n) {
                break;
            }
            if(!dq.isEmpty() && idx == n){
                while(!dq.isEmpty()){
                    if(now - dq.peekFirst().time >= w) {
                        Node first = dq.pollFirst();
                        acc -= first.weight;
                    } else {
                        now++;
                    }
                }

                break;
            }

            if(dq.isEmpty()){
                Node node = new Node(arr[idx], now);
                acc += arr[idx];
                dq.addLast(node);
                idx++;
            } else {
                Node first = dq.peekFirst();
                if(now - first.time>= w){
                    acc -= first.weight;
                    dq.pollFirst();
                }

                if(acc + arr[idx] <= l){
                    Node node = new Node(arr[idx], now);
                    acc += arr[idx];
                    dq.addLast(node);
                    idx++;
                }
            }


            now++;
        }

        System.out.println(now);
    }

    static class Node {
        int weight;
        int time;

        Node(int weight, int time) {
            this.weight = weight;
            this.time = time;

        }
    }
}