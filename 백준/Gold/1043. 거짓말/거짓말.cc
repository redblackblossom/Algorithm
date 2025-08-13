//#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
    //freopen("input.txt", "rt", stdin);
    int n, m, know,a,b;
    cin >> n >> m>> know;
    vector<int> ch(n + 1);
    vector<vector<int>> party(m);
    vector<int> party_ch(m);
    vector<int> know_ch(n+1);
    queue<int> know_arr;
    for (int i = 0; i < know; ++i) {
        cin >> a;
        know_arr.push(a);
        know_ch[a] = 1;
    }
    for (int i = 0; i < m; ++i) {
        cin >> a;
        for (int j = 0; j < a; ++j) {
            cin >> b;
            party[i].push_back(b);
        }
    }
    ;
    int cnt = 0;
    while (!know_arr.empty()) {
        int x = know_arr.front();
        know_arr.pop();
        for (int i = 0; i < m; ++i) {
            if (party_ch[i] == 0&& find(party[i].begin(), party[i].end(), x) != party[i].end()) {
                party_ch[i] = 1;
                for (int j = 0; j < party[i].size(); ++j) {
                    if (know_ch[party[i][j]] == 0) {
                        know_ch[party[i][j]] = 1;
                        know_arr.push(party[i][j]);

                    }
                }
                cnt++;
            }
        }
    }

    cout << m - cnt;
    return 0;
}