//#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>> map;
vector<int> ch;
vector<vector<int>> dp;

void DFS(int l) {
	for (int i = 0; i < map[l].size(); ++i) {
		int next = map[l][i];
		if (ch[next] == 0) {
			ch[next] = 1;
			DFS(next);
			dp[l][0]+=max(dp[next][0], dp[next][1]);
			dp[l][1] += dp[next][0];
		}
	}
}

int main(void) {
	ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
	//freopen("input.txt", "rt", stdin);
	int n, a,b;
	cin >> n;
	map = vector<vector<int>>(n + 1, vector<int>());
	ch = vector<int>(n + 1);
	dp = vector<vector<int>>(n + 1, vector<int>(2));
	for (int i = 1; i <= n; ++i) {
		cin >> dp[i][1];
	}
	for (int i = 0; i < n - 1; ++i) {
		cin >> a >> b;
		map[a].push_back(b);
		map[b].push_back(a);
	}

	ch[1] = 1;
	DFS(1);
	cout << max(dp[1][0], dp[1][1]);
	return 0;
}