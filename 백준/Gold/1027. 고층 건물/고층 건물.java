import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] canSee = new int[N];

		if(N==1){
			System.out.println(0);
			return;
		}
		for(int i = 0; i < N; i++) {
			canSee[i]+=2;
		}
		canSee[0] = 1;
		canSee[N-1] = 1;
		for(int i =0; i<N;++i) {
			for(int j =i+2; j<N;++j){
				int acc = 0;
				for(int k = i+1; k<j;++k ){
					if(isCross(k-i, arr[k] - arr[i], j-i, arr[j] - arr[i])){
						acc++;
					}
				}

				if(acc == j-i-1){
					canSee[i]++;
					canSee[j]++;
				}
			}
		}
		int res = 0;

		for(int i =0; i<N;++i) {
			res = Math.max(res,canSee[i]);
		}

		System.out.println(res);
	}

	static boolean isCross(int x1, int y1,int x2, int y2) {
		long cross = (long)x1 * y2 - (long)y1 * x2;
		if(cross >0){
			return true;
		}
		return false;
	}
}
