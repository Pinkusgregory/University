#include "stdafx.h"
#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <iomanip>

using namespace std;

int vector[13];
int counter[13];
int N = 13, V = 25;
int flag;
void TaskSum(void) {
	int i, j, sum, cnt, MaxN;
	MaxN = int(pow(2, N) - 1);
	flag = 0; i = 0;
	while (i<N) { counter[i] = 0; i++; }
	cnt = 1;
	do {
		sum = 0;
		i = 0;
		while (i<N) {
			sum = sum + counter[i] * vector[i];
			i++;
		}
		if (sum == V) {
			flag = 1;
			return;
		}
		j = N - 1;
		while ((counter[j] == 1) && (j != 0)) {
			counter[j] = 0;
			j = j - 1;
		}
		counter[j] = 1;
		cnt = cnt + 1;
	}
	while (cnt <= MaxN);
}
int main() {
	srand(time(NULL));
	int i;
	cout << "Vector: ";
	for (i = 0; i<N; i++) {
		vector[i] = rand () % 90;
		cout << vector[i] << " ";
	}
	cout << endl;
	flag = 0;
	TaskSum();
	if (flag == 1) {
		cout << "OK" << endl;
		for (int k = 0; k < N; k++) {
			cout << counter[k] << " ";
		}
		cout << endl;
		for (int k = 0; k < N; k++) {
			cout << vector[k] << " ";
		}
	}
	else {
		cout << "NO elements giving the sum" << endl;
	}

	return 0;
};