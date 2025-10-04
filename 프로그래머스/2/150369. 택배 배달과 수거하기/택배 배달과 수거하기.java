import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        PriorityQueue<Node> box = new PriorityQueue<>(
        (o1,o2) -> o2.idx - o1.idx
        );
        
        PriorityQueue<Node> empty = new PriorityQueue<>(
        (o1,o2) -> o2.idx - o1.idx
        );
        
        for(int i =0; i<deliveries.length; ++i){
            if(deliveries[i] ==0) continue;
            box.add(new Node(i+1, deliveries[i]));
        }
        
        for(int i =0; i<pickups.length; ++i){
            if(pickups[i] ==0) continue;
            empty.add(new Node(i+1, pickups[i]));
        }
        
        while(true){
            if(box.isEmpty() && empty.isEmpty()){
                break;
            }
            int a = 0;
            int b = 0;
            
            if(!box.isEmpty()) {
                a = box.peek().idx;
            }
            if(!empty.isEmpty()) {
                b = empty.peek().idx;
            }
            answer += Math.max(a,b) *2;
            
            int tmp = 0;
            
            while(!box.isEmpty()){
                Node now = box.poll();
                
                if(now.value + tmp < cap){
                    tmp += now.value;
                } else if(now.value + tmp == cap) {
                    break;
                } else {
                    box.add(new Node (now.idx, now.value - (cap - tmp)));
                    break;
                }
            }
            
            
            tmp = 0;
            while(!empty.isEmpty()){
                Node now = empty.poll();
                if(now.value + tmp < cap){
                    tmp += now.value;
                } else if(now.value + tmp == cap) {
                    break;
                } else {
                    empty.add(new Node (now.idx, now.value - (cap - tmp)));
                    break;
                }
            }
            
            
            
            
        }
        
        
        
        return answer;
    }
    
    class Node {
        int idx;
        int value;
        
        Node (int a, int b){
            idx = a;
            value = b;
        }
    }
}