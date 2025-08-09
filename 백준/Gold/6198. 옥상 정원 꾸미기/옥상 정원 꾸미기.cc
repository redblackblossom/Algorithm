//#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
    //freopen("input.txt", "rt", stdin);
    map<int, int> m;
    int n,tmp;
    long long res =0;
    cin >> n;
    long long acc = 0;
    for (int q = 0; q < n; ++q) {
        cin >> tmp;
        if (m.empty()) {
            m[tmp]++;
            acc++;
        }
        else {
            for (auto it = m.begin(); it != m.end();) {
                if (it->first <= tmp) {
                    it = m.erase(it);
                    acc--;
                }
                else {
                    break;
                }
            }
            res += acc;
            m[tmp]++;
            acc++;
        }
    }
    cout << res << "\n";
    return 0;
}