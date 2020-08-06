#include <iostream>
#include <unordered_map>

using namespace std;

//for faster input
void fast() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
}

//find method of the union-find algorithm
int find(int parents[], int a) {
	int p_a = parents[a];
	if(p_a == a) return p_a;
	parents[a] = find(parents, p_a);
	return parents[a];
}

//union method of the union-find implementation (union by rank)
//c++ has a definition of union so can't use union
void unite(int a, int b, int parents[], int ranks[]) {
	int p_a = find(parents, a);
	int p_b = find(parents, b);
	
	if(p_a == p_b) return;

	if(ranks[p_a] > ranks[p_b]) parents[p_b] = p_a;
	else if(ranks[p_b] > ranks[p_a]) parents[p_a] = p_b;
	else {
		parents[p_a] = p_b;
		ranks[p_b] += 1;
	}
}
int main() {

	fast();

	int cases;
	cin >> cases;

	for(int i = 0; i < cases; i++) {

		int friendshipsFormed;
		cin >> friendshipsFormed;

		//initialization of arrays and hashmap
		int parents[100001];
		int ranks[100001];
		int sizes[100001];
		unordered_map<string, int> names;

		int endPointer = 0;

		for(int j = 0; j < friendshipsFormed; j++) {

			string friend1;
			string friend2;
			cin >> friend1 >> friend2;

			//int to keep tab of the friend's positions
			//in arrays
			int position1 = -1, position2 = -1;

			unordered_map<string, int>::iterator itr;
			itr = names.find(friend1);
			//if not found in the map, add to it
			if(itr == names.end()) {
				names[friend1] = endPointer;
				parents[endPointer] = endPointer;
				ranks[endPointer] = 1;
				sizes[endPointer] = 1;
				position1 = endPointer;
				endPointer++;
			}
			//similar process with second one
			itr = names.find(friend2);

			if(itr == names.end()) {
				names[friend2] = endPointer;
				parents[endPointer] = endPointer;
				ranks[endPointer] = 1;
				sizes[endPointer] = 1;
				position2 = endPointer;
				endPointer++;
			}

			//if the position int's are negative, it means
			//the name has been initialized before so find its location
			if(position1 < 0) position1 = names.at(friend1);
			if(position2 < 0) position2 = names.at(friend2);

			//find the respective parents
			int p_a = find(parents, position1);
			int p_b = find(parents, position2);

			//if they have different parents, add their sizes
			if(p_a != p_b) {
				sizes[p_a] += sizes[p_b];
				sizes[p_b] = sizes[p_a];
			}

			//union the 2 names
			unite(position1, position2, parents, ranks);

			cout << sizes[p_a] << "\n";
		}
	}

	return 0;
}