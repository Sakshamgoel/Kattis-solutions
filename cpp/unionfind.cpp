#include <iostream>

using namespace std;

int parents[1000001];
int ranks[1000001];

void fast() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
}

int find(int a) {
	int p_a = parents[a];
	if(p_a == a) return p_a;
	parents[a] = find(p_a);
	return parents[a];
}

void unite(int a, int b) {
	int p_a = find(a);
	int p_b = find(b);

	if(ranks[p_a] > ranks[p_b]) parents[p_b] = p_a;
	else if(ranks[p_b] > ranks[p_a]) parents[p_a] = p_b;
	else {
		parents[p_a] = p_b;
		ranks[p_b] += 1;
	}
}

int main() {

	fast();
	int maxSize;
	int cases;

	cin >> maxSize >> cases;

	for(int i = 0; i < maxSize; i++) {
		parents[i] = i;
		ranks[i] = 1;
	}

	for(int i = 0; i < cases; i++) {
		char c;
		int num1;
		int num2;
		cin >> c >> num1 >> num2;

		if(c == '=') unite(num1, num2);
		else {
			if(find(num1) == find(num2)) {
				cout << "yes" << "\n";
			} else {
				cout << "no" << "\n";
			}
		}

	}

	
}