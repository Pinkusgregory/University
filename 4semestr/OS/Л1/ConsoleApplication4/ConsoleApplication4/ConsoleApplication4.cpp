#include "stdafx.h"
#include "algorithm"
#include "iostream"

using namespace std;

int main()
{
	/*int i,n;
	int x[20];

	cout << "Enter n" << endl;
	cin >> n;

	cout << "Enter mas" << endl;

	for (i = 0; i < n; i++) {
		cin >> x[i];
	}


	for (i = 0; i < n-1 ; i++) {
		int i1 = i;
		for (int i2 = i + 1; i2 < n; i2++) {
			if (x[i2] > x[i1]) {
				i1 = i2;
			}
		}
		swap(x[i], x[i1]);
	}


	for (i = 0; i < n; i++) {
		cout << x[i] << "";
	}*/

	int i, n, m, j;
	int x[20][20];
	int x1[20];

	cout << "Enter n" << endl;
	cin >> n;

	cout << "Enter m" << endl;
	cin >> m;

	cout << "Enter mas" << endl;

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			cin >> x[i][j];
		}
	}

	for (i = 0; i < m; i++) {
		int max = -32000;
		for (j = 0; j < n; j++) {
			if (x[j][i] > max) {
				max = x[j][i];
			}
		}
		x1[i] = max;
	}

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			cout << x[i][j] << " ";
		}
		cout << endl;
	}

	cout << endl;

	for (i = 0; i < m; i++) {
		cout << x1[i] << "";
	}

    return 0;
}

