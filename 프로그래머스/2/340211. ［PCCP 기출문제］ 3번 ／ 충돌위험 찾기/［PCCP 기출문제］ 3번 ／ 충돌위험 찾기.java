import java.util.*;

class Solution {
    
    class Node {
        int x;
        int y;
        int isLive;
        public Node (int a, int b){
            x = a;
            y = b;
            isLive = 1;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y && isLive == node.isLive;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, isLive);
        }
    }
    
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int [][] map = new int[101][101];
        int n = routes.length;
        Node [] now = new Node[n];
        List<List<Integer>> li = new LinkedList<>();
        
        for(int i =0; i<n;++i){
            int point = routes[i][0] - 1;
            now[i] = new Node(points[point][0], points[point][1]);
        }
        
        for(int i =0; i<n;++i){
            li.add(new LinkedList<>());
            for(int j=1; j<routes[i].length; ++j){
                
                int nowPoint = routes[i][j-1] - 1;
                int nowX = points[nowPoint][0];
                int nowY = points[nowPoint][1];
                
                int nextPoint = routes[i][j] - 1;
                int nextX = points[nextPoint][0];
                int nextY = points[nextPoint][1]; 
                
                //목적지가 더 아래임
                if(nowX < nextX) {
                    for(int k =0; k<nextX - nowX ; ++k){
                        li.get(i).add(1);
                    }
                } else {
                    //목적지가 위임
                    for(int k =0; k< nowX - nextX; ++k){
                        li.get(i).add(3);
                    }
                }
                
                if(nowY < nextY) {
                    //목적지가 오른쪽임
                    for(int k =0; k<nextY - nowY ; ++k){
                        li.get(i).add(0);
                    }
                } else {
                    //목적지가 위임
                    for(int k =0; k< nowY - nextY; ++k){
                        li.get(i).add(2);
                    }
                }
            }
        }
        
        answer += check(now);
        
        int lived = n;
        while (lived != 0) {
            for (int i = 0; i < n; ++i) {
                if (now[i].isLive != 1) continue;

                if (!li.get(i).isEmpty()) {
                    int dir = ((LinkedList<Integer>) li.get(i)).poll(); 
                    now[i].x += dx[dir];
                    now[i].y += dy[dir];
                } else {
                    now[i].isLive = 0;
                    lived--;
                }
            }
            answer += check(now);
        }
        
        
        
        return answer;
    }
    
    int check(Node [] now){
        Map<Node, Integer> m = new HashMap<>();
        int result = 0;
        for(int i =0; i<now.length; ++i){
            if(now[i].isLive != 1){
                continue;
            }
            if(m.containsKey(now[i])){
                m.put(now[i], 1 + m.get(now[i]));
            } else {
                m.put(now[i], 1);
            }
        }
        
        for(Node key : m.keySet()){
            if(m.get(key) >= 2){
                result++;
            }
        }
        return result;
    }
}