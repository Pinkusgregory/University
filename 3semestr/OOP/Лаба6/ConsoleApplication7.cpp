#include "pch.h"
#include <iostream>
#include <cstring>
#include <sstream>
#include <math.h>

using namespace std;

class MatrixInt {
private:
	int x;
	int	y;
	int m[20][20];
public:
	MatrixInt() {
		int i, j;
		x = y = 2;
		for (i = 0; i < x; i++) {
			cout << "Enter " << i + 1 << " stroky" << endl;
			for (j = 0; j < y; j++) {
				cout << "Enter " << j + 1 << " element " << i + 1 << " stroki" << endl;
				cin >> m[i][j];
			}
		}
	};
	MatrixInt(int x, int y) {
		int i, j;
		for (i = 0; i < x; i++) {
			cout << "Enter " << i + 1 << " stroky" << endl;
			for (j = 0; j < y; j++) {
				cout << "Enter " << j + 1 << " element " << i + 1 << " stroki" << endl;
				cin >> m[i][j];
			}
		}
	};
	string OutputMat() {
		int i, j;
		string str;
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				ostringstream ss;
				string str1;
				ss << m[i][j];
				str1 = ss.str();
				str += str1 + " ";
			}
			str += "\n";
		}
		return str;
	};
	friend const MatrixInt& operator--(MatrixInt& q);
	friend const MatrixInt& operator++(MatrixInt& q);
};

const MatrixInt& operator--(MatrixInt& q) {
	int i, j;
	for (i = 0; i < q.x; i++) {
		for (j = 0; j < q.y; j++) {
			q.m[i][j] = abs(q.m[i][j]);
		}
	}
	return q;
}

const MatrixInt& operator++(MatrixInt& q); {
	int i, j, max;
	max = 0;
	for (i = 0; i < q.x; i++) {
		for (j = 0; j < q.y; j++) {
			if
	for (i = 0; i < q.x; i++) {
		for (j = 0; j < q.y; j++) {
			if (q.m[i][j] == 0) {
				
			}
		}
	}
	return q;
};

int main()
{
	MatrixInt ob1;
	cout << "Matrix:" << endl;
	cout << ob1.OutputMat() << endl;
	--ob1;
	cout << "--Matrix:" << endl;
	cout << ob1.OutputMat() << endl;
}
