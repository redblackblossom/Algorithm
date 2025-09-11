import java.util.*;

public class Main {

	static int[][] arr;
	static int MAX = Integer.MAX_VALUE/3;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		arr = new int[n][n];

		for(int i = 0; i < n; i++) {
			Arrays.fill(arr[i], MAX);
			arr[i][i] = 0;
		}

		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;
			b--;
			arr[a][b] = 1;
			//arr[b][a] = -1;
		}

		for(int k =0; k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j = 0; j<n;++j) {
					if(arr[i][j] > arr[i][k] + arr[k][j]){
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int ans = 0;

		for(int i =0; i<n;++i) {
			boolean flag = true;
			for(int j =0; j<n;++j) {
				if(arr[i][j] == MAX && arr[j][i] == MAX) {
					flag = false;
					break;
				}
			}
			if(flag){
				ans++;
			}

		}

		System.out.println(ans);

	}
}
