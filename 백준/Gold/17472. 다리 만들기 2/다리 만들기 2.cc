//#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

struct Node {
    int x, val;
    Node() {}
    Node(int a, int b) : x(a), val(b) {}
    bool operator< (const Node& b)const {
        return val > b.val;
    }
};

int main(void) {
    ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
    //freopen("input.txt", "rt", stdin);
    int n, m;
    cin >> n >> m;
    vector<vector<int>> arr(n, vector<int>(m));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> arr[i][j];
        }
    }
    int land = 0;
    //설치할 수 있는 모든 다리를 설치한 후, 최소신장트리를 구함.
    //섬의 개수를 count함. 2번부터 시작함
    queue<pair<int, int>> Q;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (arr[i][j] == 1) {
                Q.push({ i,j });
                arr[i][j] = land + 2;
                while (!Q.empty()) {
                    int x = Q.front().first;
                    int y = Q.front().second;
                    Q.pop();
                    for (int i = 0; i < 4; ++i) {
                        int xx = x + dx[i];
                        int yy = y + dy[i];
                        if (xx < 0 || xx >= n || yy < 0 || yy >= m || arr[xx][yy] != 1) continue;
                        Q.push({ xx,yy });
                        arr[xx][yy] = land + 2;
                    }
                }
                land++;
            }
        }
    }

    vector<vector<pair<int,int>>> map(land+2);
    //설치 가능한 모든 다리를 알아냄
    //가로 다리 설치
    for (int i = 0; i < n; ++i) {
        vector<pair<int, int>> val;
        pair<int, int> start;
        for (int j = 0; j < m; ++j) {
            if (arr[i][j] == 0) continue;
            else if (arr[i][j] != 0 ) {
                start = { arr[i][j], j };
                val.push_back(start);
                for (int k = j+1; k < m; ++k) {
                    if (arr[i][j] == arr[i][k]) {
                        start = { arr[i][j], k };
                    }
                    else break;
                }
                j = start.second;
                val.push_back(start);
            }
        }
        if (val.size() < 4) continue;
        for (int j = 1; j < val.size() - 1; j+=2) {
            int x = val[j].first;
            int y = val[j + 1].first;
            int dis = val[j + 1].second - val[j].second - 1;
            if (x != y && dis >= 2) {
                map[x].push_back({ y,dis });
                map[y].push_back({ x,dis });
            }
        }
    }

    //섬들을 Transpose하면 세로 다리를 놓는 계산을 가로 다리를 놓는 것과 같은 코드로 계산 할 수 있음
    vector<vector<int>> arr_T(m, vector<int>(n));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            arr_T[j][i] = arr[i][j];
        }
    }

    for (int i = 0; i < m; ++i) {
        vector<pair<int, int>> val;
        pair<int, int> start;
        for (int j = 0; j < n; ++j) {
            if (arr_T[i][j] == 0) continue;
            else if (arr_T[i][j] != 0) {
                start = { arr_T[i][j], j };
                val.push_back(start);
                for (int k = j + 1; k < n; ++k) {
                    if (arr_T[i][j] == arr_T[i][k]) {
                        start = { arr_T[i][j], k };
                    }
                    else break;
                }
                j = start.second;
                val.push_back(start);
            }
        }
        if (val.size() < 4) continue;
        for (int j = 1; j < val.size() - 1; j += 2) {
            int x = val[j].first;
            int y = val[j + 1].first;
            int dis = val[j + 1].second - val[j].second - 1;
            if (x != y && dis >= 2) {
                map[x].push_back({ y,dis });
                map[y].push_back({ x,dis });
            }
        }
    }

    //map이 비어있으면 -1출력
    int flag = 1;
    for (int i = 0; i < map.size(); ++i) {
        if (map[i].size() != 0) {
            flag = 0;
            break;
        }
    }
    if (flag) {
        cout << -1;
        return 0;
    }

    //이제 최소 신장 트리를 구하면 됨. 2번 섬 부터 시작해서 최소신장트리 사용
    vector<int> ch(land + 2,100000000);
    vector<vector<Node>> Nodes(land + 2);
    for (int i = 0; i < map.size(); ++i) {
        for (int j = 0; j < map[i].size(); ++j) {
            Nodes[i].push_back({ map[i][j].first,map[i][j].second });
        }
    }
    ch[2] = 0;
    priority_queue<Node> pQ;
    pQ.push({2,0});
    while (!pQ.empty()) {
        int x = pQ.top().x;
        int val = pQ.top().val;
        if(ch[x] > val)ch[x] = val;
        pQ.pop();
        for (int i = 0; i < Nodes[x].size(); ++i) {
            if (ch[Nodes[x][i].x] == 100000000) {
                pQ.push(Nodes[x][i]);
            }
        }
    }
    int res = 0;
    for (int i = 2; i < ch.size(); ++i) {
        if (ch[i] == 100000000) {
            cout << -1;
            return 0;
        }
        res += ch[i];
    }
    cout << res;
    return 0;
}