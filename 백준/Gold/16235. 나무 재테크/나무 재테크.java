import java.util.*;

public class Main {

	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[][] A = new int[n][n];
		int[][] arr = new int[n][n];
		int[][] tmp = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = sc.nextInt();
				arr[i][j] = 5;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);

		for(int i =0; i<m;++i){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			Node node = new Node(c,a,b);
			pq.add(node);
		}

		while(k-->0) {
			//봄

			PriorityQueue<Node> pqTmp = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);
			//System.out.println(pq.size());
			while(!pq.isEmpty()) {
				Node now = pq.poll();

				if(arr[now.x][now.y] >= now.age ){
					arr[now.x][now.y] -= now.age;
					now.age += 1;
					pqTmp.add(now);
				} else {
					tmp[now.x][now.y] += now.age / 2;
				}
			}

			pq = pqTmp;
			pqTmp = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);
			//System.out.println(pq.size());

			//여름

			for(int i =0; i<n;++i){
				for(int j =0; j<n;++j){
					arr[i][j] += tmp[i][j];
					tmp[i][j] = 0;
				}
			}


			//가을
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				if(now.age % 5 == 0) {
					for(int dir = 0; dir < 8; dir++) {
						int nx = now.x + dx[dir];
						int ny = now.y + dy[dir];

						if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

						pqTmp.add(new Node(1, nx, ny));
					}
				}
				pqTmp.add(now);
			}

			pq = pqTmp;
			pqTmp = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);

			//System.out.println(pq.size());


			//겨울
			for(int i =0; i<n;++i){
				for(int j =0; j<n;++j){
					arr[i][j] += A[i][j];
				}
			}

		}

		System.out.println(pq.size());

	}

	static class Node {
		int age;
		int x;
		int y;

		public Node(int age, int x, int y) {
			this.age = age;
			this.x = x;
			this.y = y;
		}
	}
}


