#include "stdafx.h"
#include <Windows.h>
#include <iostream>
#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <ctime>

#pragma warning(disable:4996)
using namespace std;


int vector[10];



// Cоздание массива из 10 псевдослучайных целых чисел величиной от 0 до 100
// массив записывается в файл Example_TA2.TXT, на экран выводим максимальное // целое  49

void create_array(int Nmax) {
	
	int i;

	FILE *stream;

	//Nmax = 10; соответствует размерности массива
	stream = fopen("test.TXT", "w+");

	cout << "Maximal integer "; cout << RAND_MAX;

	printf("\n%d%s\n", Nmax, " random numbers from 0 to 950");

	for (i = 0; i<Nmax; i++) {

		vector[i] = rand() % 950;
		//printf("%d\n", vector[i]);
		cout << vector[i] << " ";
		if (i % 20 == 0) {
			cout << endl;
		}
		fprintf(stream, "%d\n", vector[i]);
	}
	cout << endl;
	fclose(stream);
}

void main() {

	srand(time(NULL));

	int i,
		N,
		min, // значение минимума
		cnt,
		raznica;
	double result;

	cout << "Input amount of numbers" << endl;
	cin >> N;
	
	cout << "Harmonic number:";
	result = log(N) + 0.57;
	// harmonic(N) – функция подсчета n-го гармоническго числа
	
	cout << result << endl;
	
	create_array(N);
	//генерация массива псевдослучайных чисел
	
	min = vector[0];
	
	cnt = 1;
	for (i = 1; i<N; i++) {
		if (vector[i]<min) { min = vector[i]; cnt++; }
	}

	raznica = abs(result - cnt);
	cout << "Minimal " << min << endl;
	cout << "Num oper " << cnt << endl;
	cout << "Raznica " << raznica << endl;
}