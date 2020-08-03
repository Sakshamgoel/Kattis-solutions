
#include <iostream>
int parents [200001];
void unin(int a, int b);
int find(int a);
bool something = false;

int main()
{
    int n = 0;
    int m = 0;
    std::cin >> n >> m;
    for (int i = 0; i < n + 1; i++) {
        parents[i] = i;
    }
    for (int i = 0; i < m; i++) {
        int num1 = 0;
        int num2 = 0;
        std::cin >> num1 >> num2;
        unin(num1, num2);
    }
    for (int i = 1; i <= n; i++) {
        if (find(i) != 1) {
            std::cout << i << "\n";
            something = true;
        }
    }
    if (!something) {
        std::cout << "Connected";
    }
    return 0;
}
void unin(int a, int b) {
    int p_a = find(a);
    int p_b = find(b);
        if (p_a < p_b) {
            parents[p_b] = p_a;
        }
        else if (p_b < p_a) {
            parents[p_a] = p_b;
        }
}
int find(int a) {
    int p_a = parents[a];
    if (p_a == a) {
        return p_a;
    }
    parents[a] = find(p_a);
    return parents[a];
}