import java.util.*;

public class Main {

	static int[][] arr;
	static int MAX = Integer.MAX_VALUE/3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		arr = new int[n][n];

		for(int i =0; i<n;++i) {
			Arrays.fill(arr[i], MAX);
			arr[i][i] = 0;
		}

		for(int i =0; i<k;++i) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			arr[a][b] = 1;
			arr[b][a] = -1;
		}

		for(int u =0; u<n;++u) {
			for(int i= 0; i<n;++i) {
				for(int j =0; j<n;++j) {
					if(arr[i][u] == 1 && arr[u][j] == 1) {
						arr[i][j] = 1;
						arr[j][i] = -1;
					}
					if(arr[i][u] == -1 && arr[u][j] == -1) {
						arr[i][j] = -1;
						arr[j][i] = 1;
					}
				}
			}
		}

		int s = sc.nextInt();
		for(int i =0; i<s;++i) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			if(arr[a][b] == 1){
				System.out.println(-1);
			} else if(arr[a][b] == -1){
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
