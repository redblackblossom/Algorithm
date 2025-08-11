import java.util.*;

public class Main {
    static final long INF = (long)1e15; // 충분히 큰 값 (오버플로 방지용)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 수 (1-indexed 가정)
        int m = sc.nextInt(); // 간선 수

        // dp[i][j] : i->j 최단거리
        // arr[i][j]: i->j 직접 간선 가중치(없으면 INF)
        long[][] dp  = new long[n + 1][n + 1];
        long[][] arr = new long[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; ++i) {
            Arrays.fill(dp[i], INF);
            Arrays.fill(arr[i], INF);
            dp[i][i] = 0;    // 자기 자신까지 최단거리 0
            arr[i][i] = 0;   // 자기 자신으로의 직접 간선은 0(의미상)
        }

        // 간선 입력
        for (int i = 0; i < m; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            // 1) 자기자신 간선 무시(초기 대각선 0을 깨지 않도록)
            if (a == b) continue;

            // 2) 최소 가중치만 유지(==0 체크 불필요, 초기값은 INF이므로)
            if (arr[a][b] > c) {
                arr[a][b] = c;
                arr[b][a] = c;        // 무방향 그래프
                // 방향 그래프라면 ↑ 이 줄을 지우고 아래 두 줄 중 하나만 유지:
                // arr[a][b] = c;

                dp[a][b] = c;
                dp[b][a] = c;         // 무방향일 때만
                // 방향 그래프라면 ↑ 이 줄도 지우기:
                // dp[a][b] = c;
            }
        }

        // Floyd–Warshall
        // 오버플로/불필요 연산 방지를 위해 INF 체크를 한 뒤 더한다
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                if (dp[i][k] == INF) continue;
                for (int j = 1; j <= n; ++j) {
                    if (dp[k][j] == INF) continue;
                    long nd = dp[i][k] + dp[k][j];
                    if (dp[i][j] > nd) {
                        dp[i][j] = nd;
                    }
                }
            }
        }

        // ans[i][j]: i에서 j로 갈 때 "첫 이동 노드"
        int[][] ans = new int[n + 1][n + 1];

        // next hop 계산
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j) continue;           // 자기 자신은 '-'
                if (dp[i][j] == INF) continue;  // 도달 불가

                long target = dp[i][j];

                // i에서 인접한 k로 한 번 이동하고 k->j 최단거리를 붙였을 때
                // 전체 최단거리와 같다면, 그 k가 첫 이동 노드
                for (int k = 1; k <= n; ++k) {
                    if (i == k) continue;
                    if (arr[i][k] == INF) continue;  // i-k 직접 간선 없음
                    if (dp[k][j] == INF) continue;   // k에서 j로 못 감

                    if (arr[i][k] + dp[k][j] == target) {
                        ans[i][j] = k;
                        break; // 첫 번째로 발견된 k를 사용(사전순 최소)
                    }
                }
                // 여기서 ans[i][j]가 0이면(희박하지만) “여러 최단경로 중 첫 hop을 못찾은 경우”
                // 이론상 발생하지 않지만, 안전하게 두고 싶다면 추가 체크/로그 가능
            }
        }

        // 출력 형식
        // i==j 또는 도달불가(dp==INF)면 "-",
        // 그 외에는 첫 이동 노드(ans[i][j]) 출력
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j || dp[i][j] == INF) {
                    System.out.print("- ");
                } else {
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
