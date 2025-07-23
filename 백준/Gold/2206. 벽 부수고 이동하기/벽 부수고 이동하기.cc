//#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n, m;
int maps[1001][1001];
int ch[1001][1001][2];
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
struct pos {
    int x, y, breaked;
    pos(int a, int b, int c) :x(a), y(b), breaked(c) {}
};

int main(void) {
    ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
    //freopen("input.txt", "rt", stdin);
    cin >> n >> m;
    string str;
    for (int i = 1; i <= n; ++i) {
        cin >> str;
        for (int j = 0; j < m; ++j) {
            maps[i][j+1] = str[j] - '0';
        }
    }

    queue<pos> Q;
    Q.push({ 1,1,0 });
    ch[1][1][0] = 1;
    int flag = -1;
    while (!Q.empty()) {
        int x = Q.front().x;
        int y = Q.front().y;
        int breaked = Q.front().breaked;
        Q.pop();
        if (x == n && y == m) {
            flag = ch[x][y][breaked];
            break;
        }

        for (int i = 0; i < 4; ++i) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx<1 || xx>n || yy<1 || yy>m)continue;
            if (ch[xx][yy][breaked] != 0) continue;
            
            if (maps[xx][yy] == 0) {
                Q.push({ xx,yy,breaked });
                ch[xx][yy][breaked] = ch[x][y][breaked] + 1;
            }
            if (maps[xx][yy] == 1 && breaked == 0) {
                Q.push({ xx,yy,1 });
                ch[xx][yy][1] = ch[x][y][breaked] + 1;
            }
        }

    }
    cout << flag;
    return 0;
}