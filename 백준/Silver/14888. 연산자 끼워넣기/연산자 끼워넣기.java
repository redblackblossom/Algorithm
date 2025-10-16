import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int[] op = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n];
		for(int i =0; i<n;++i){
			arr[i] = sc.nextInt();
		}

		for(int i =0; i<4;++i){
			op[i] = sc.nextInt();
		}

		recursive(1,arr[0]);

		System.out.println(max);
		System.out.println(min);

	}

	static void recursive(int depth, int value) {
		if(depth == n){
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for(int i =0; i<4;++i){
				if(op[i]>0){
					op[i]--;
					switch(i){
						case 0:
							recursive(depth+1, value + arr[depth]);
							break;
						case 1:
							recursive(depth+1, value - arr[depth]);
							break;
						case 2:
							recursive(depth+1, value * arr[depth]);
							break;
						case 3:
							recursive(depth+1, value / arr[depth]);
							break;
					}
					op[i]++;
				}
			}
		}
	}

}
