import java.awt.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Node[] arr = new Node[2 * n];

		for (int i = 0; i < n; i++) {
			int tmp =  sc.nextInt();
			arr[i] = new Node(tmp, 0);
		}
		for (int i = 0; i < n; i++) {
			int tmp =  sc.nextInt();
			arr[i+n] = new Node(tmp, 0);
		}

		int start = 0;
		int end = n-1;
		int cnt = 0;
		int nowRobotIdx =0;
		Deque<Robot> dq = new ArrayDeque<>();
		int ans = 0;


		while(true){
			if(cnt >=k) break;
			start = rotate(start, n);
			end = rotate(end, n);

			int size = dq.size();
			for(int i =0; i < size; i++){
				Robot r = dq.pollFirst();
				if(r.current != end) {
					dq.addLast(r);
				} else {
					arr[r.current].ch = 0;
				}
			}

			if(!dq.isEmpty()){
				size = dq.size();

				for(int i = 0; i < size; i++){
					Robot r = dq.pollFirst();
					int cur = r.current;
					int next = next(r.current, n);
					if(arr[next].life >0 && arr[next].ch ==0){
						arr[cur].ch = 0;
						if (next == end) {
							arr[end].ch = 0;
							if (--arr[next].life == 0) cnt++;
						} else {
							arr[next].ch = 1;
							if (--arr[next].life == 0) cnt++;
							dq.addLast(new Robot(r.idx, next));
						}
					} else {
						dq.addLast(r);
					}
				}
			}

			if(arr[start].ch == 0 && arr[start].life >0){
				arr[start].ch =1;
				arr[start].life--;
				if(arr[start].life ==0){
					cnt++;
				}
				dq.addLast( new Robot(nowRobotIdx++, start));
			}


			ans++;
		}

		System.out.println(ans);
	}

	static int rotate(int idx, int n) {
		idx --;
		if(idx ==-1){
			idx = 2*n -1;
		}

		return idx;
	}

	static int next(int idx, int n) {
		idx ++;
		if(idx == 2*n){
			idx =0;
		}

		return idx;
	}

	static class Node {
		int life;
		int ch;

		Node(int life, int ch) {
			this.life = life;
			this.ch = ch;
		}
	}

	static class Robot {
		int idx;
		int current;
		Robot(int idx, int current) {
			this.idx = idx;
			this.current = current;
		}
	}
}
