import java.util.*;

public class Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,m,k;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        
        int arr[][][] = new int[n][m][k+1];
        char map[][] = new char[n][m];
        
        
        for(int i =0; i<n;++i) {
        	for(int j =0; j<m;++j) {
        		for(int q =0; q<=k;++q) {
        			arr[i][j][q] = Integer.MAX_VALUE;
        		}
        	}
        }
        
        
        for(int i =0; i<n;++i) {
        	String s = sc.nextLine();
        	for(int j = 0; j<m;++j) {
        		map[i][j] = s.charAt(j);
        	}
        }
        
        Deque<Node> dq = new ArrayDeque<>();
        
        
        dq.add(new Node(0,0,0,1));
        arr[0][0][0] = 1;
        
        while(!dq.isEmpty()) {
        	Node nowNode = dq.pollFirst();
        	
        	for(int i =0; i<4;++i) {
        		int nextX = nowNode.x + dx[i];
        		int nextY = nowNode.y + dy[i];
        		int nextVal = nowNode.val + 1;
        		
        		if(nextX < 0 || nextY < 0 || nextX >=n || nextY >=m) {
        			continue;
        		}
        		
        		if(map[nextX][nextY]=='1') {
        			if(nowNode.cnt >= k) {
        				continue;
        			} else {
        				if(arr[nextX][nextY][nowNode.cnt +1] > nextVal) {
            				arr[nextX][nextY][nowNode.cnt+ 1] = nextVal;
            				dq.add(new Node(nextX, nextY, nowNode.cnt + 1, nextVal));
            			}
        			}	
        		} else {
        			if(arr[nextX][nextY][nowNode.cnt] > nextVal) {
        				arr[nextX][nextY][nowNode.cnt] = nextVal;
        				dq.add(new Node(nextX, nextY, nowNode.cnt, nextVal));
        			}
        		}
        		
        	}
        }
        
        for(int i =0; i<=k;++i) {
        	answer = Math.min(answer, arr[n-1][m-1][i]);
        }
        if(answer == Integer.MAX_VALUE) {
        	System.out.println(-1);
        } else {
        	System.out.println(answer);
        }
        
    }
    
    static class Node {
    	int x;
    	int y;
    	int cnt;
    	int val;
    	
    	Node(int a, int b, int c, int d){
    		x = a;
    		y = b;
    		cnt = c;
    		val = d;
    	}
    }
}
