import java.util.*;

public class Main {
	static int[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		output = new int[m];
		DFS(n,m,0,0);
	}

	static void DFS(int n, int r, int depth, int start) {
		if(depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
		} else {
			for(int i = start; i<n;++i){
				output[depth] = i+1;
				DFS(n,r,depth+1,i+1);
			}
		}
	}
}
