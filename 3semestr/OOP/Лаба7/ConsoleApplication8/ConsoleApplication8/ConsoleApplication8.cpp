#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

template <class T>
T** Replace(T** x, int y)
{
	int i, j;
	for (i = 0; i < y; i++) {
		T temp = x[i][i];
		x[i][i] = x[y - 1 - i][i];
		x[y - 1 - i][i] = temp;
	}
	return x;
}

template <class T>
void Output(T** a, int x, int y)
{
	int i, j;
	for (i = 0; i < x; i++) {
		for (j = 0; j < y; j++) {
			cout << a[i][j] << " ";
		}
		cout << endl;
	}
}

template <class T>
void Input(T** a, int x, int y)
{
	int i, j;
	cout << "Enter Matrix:" << endl;
	for (i = 0; i < x; i++) {
		for (j = 0; j < y; j++) {
			cin >> a[i][j];
		}
	}
}

int main()
{
	int i, j;
	int row, column;
	cout << "Enter number of rows" << endl;
	cin >> row;
	cout << "Enter number of columns" << endl;
	cin >> column;
	int **a = new int*[row];
	for (i = 0; i < row; i++) {
		a[i] = new int[column];
	}
	Input(a,row,column);
	Output(a,row,column);
	Replace(a,row);
	cout << "\n";
	Output(a, row, column);
	delete[] a;
	
	float **b = new float*[row];
	for (i = 0; i < row; i++) {
		b[i] = new float[column];
	}
	Input(b,row,column);
	Output(b, row, column);
	Replace(b,row);
	cout << "\n";
	Output(b, row, column);
	delete[] b;

	char **c = new char*[row];
	for (i = 0; i < row; i++) {
		c[i] = new char[column];
	}
	Input(c, row, column);
	Output(c, row, column);
	Replace(c, row);
	cout << "\n";
	Output(c, row, column);
	delete[] c;
	return 0;
}