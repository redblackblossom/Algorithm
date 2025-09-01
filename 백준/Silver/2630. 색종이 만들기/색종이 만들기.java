import java.util.*;


public class Main {
	
	static int[][] arr;
	static int sol1 =0;
	static int sol2 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		n = sc.nextInt();
		arr = new int[n][n];
		
		for(int i =0; i<n;++i) {
			for(int j =0; j<n;++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		recursive(0,0,n,n);
		System.out.println(sol1);
		System.out.println(sol2);
	}
	
	static void recursive(int x1, int y1, int x2, int y2) {
		if(x1 - x2 ==1) {
			if(arr[x1][y1] ==0) {
				sol1++;
			} else {
				sol2++;
			}
		} else {
			int acc = 0;
			for(int i =x1; i<x2;++i) {
				for(int j = y1; j<y2;++j) {
					acc += arr[i][j];
				}
			}
			
			if(acc == 0) {
				sol1++;
				return;
			} else if(acc == (x2 -x1)*(y2 - y1)) {
				sol2 ++;
				return;
			} else {
				int xMid = (x1 + x2)/2;
				int yMid = (y1 + y2)/2;
				
				recursive(x1,y1,xMid,yMid);
				recursive(x1,yMid,xMid,y2);
				recursive(xMid,y1,x2,yMid);
				recursive(xMid,yMid, x2,y2);
			}
		}
	}
}
