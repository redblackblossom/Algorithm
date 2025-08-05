import java.util.*;

public class Main {

	static int[] ch;
	static int[] output;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ch = new int[n];
		output = new int[m];
		
		DFS(0, 0,n,m);
		
	}
	
	static void DFS(int start, int depth, int n, int r) {
		if(depth == r) {
			for(int i =0; i<output.length;++i) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =start; i<n;++i) {
			output[depth] = i+1;
			DFS(i + 1, depth + 1, n, r);	
		}
	}
	
}
