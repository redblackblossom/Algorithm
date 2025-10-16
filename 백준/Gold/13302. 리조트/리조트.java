import java.util.*;

public class Main {
	static int n,m;
	static Map<Integer, Integer> holiday = new HashMap<>();
	static int[][] dp;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dp = new int[n+1][n+1];
		for(int i =0; i<=n;++i){
			Arrays.fill(dp[i], -1);
		}

		for(int i =0; i<m;++i){
			int tmp = sc.nextInt();
			holiday.put(tmp, 1);
		}

		System.out.println(recursive(1,0));
	}

	static int recursive(int idx, int coupon) {
		if(idx > n) return 0;
		if(dp[idx][coupon] != -1) return dp[idx][coupon];
		if(holiday.containsKey(idx)){
			return recursive(idx+1, coupon);

		}
		//1일
		int case1 = recursive(idx+1, coupon) + 10000;
		//3일
		int case2 = recursive(idx+3, coupon +1) + 25000;
		//5일
		int case3 = recursive(idx+5, coupon+2) + 37000;
		//쿠폰 사용
		int case4 = 10000000;
		if(coupon >=3){
			case4 = recursive(idx+1, coupon-3);
		}

		return dp[idx][coupon] = Math.min(Math.min(case1, case2), Math.min(case3, case4));

	}

}
