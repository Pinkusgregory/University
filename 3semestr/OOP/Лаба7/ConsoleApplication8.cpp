#include "pch.h"
#include <iostream>
#include <string>

using namespace std;

template <class T> 
T** Replace(T** x)
{
	int i, j;
	for (i = 0; i < 2; i++) {
		T temp = x[i][i];
		x[i][i] = x[2 - 1 - i][i];
		x[2 - 1 - i][i] = temp;
	}
	return x;
}
int main()
{
	int i, j;
	int **a = new int* [2];
	for (i = 0; i < 2; i++) {
		a[i] = new int[2];
	}
	for (i = 0; i < 2; i++) {
		for (j = 0; j < 2; j++) {
			cin >> a[i][j];
		}
	}
	for (i = 0; i < 2; i++) {
		for (j = 0; j < 2; j++) {
			cout << a[i][j] << " ";
		}
		cout << endl;
	}
	Replace(a);
	for (i = 0; i < 2; i++) {
		for (j = 0; j < 2; j++) {
			cout << a[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}