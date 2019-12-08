#include "pch.h"
#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <iomanip>

using namespace std;

struct Write {
	int num;
	struct Write *next;
	struct Write *prev;
};

void Add(int x, Write *MyList)                          
{
	Write *temp = new Write;                              		
	temp->num = x;                                        
	temp->next = MyList->prev;                          
	MyList->prev = temp;                                
}

void Show(Write *MyList) {
	Write *temp = MyList->prev;
	while (temp != NULL) {
		cout << temp->num << " ";
		temp = temp->next;
	}
	cout << endl;
}

void Clear(Write *MyList) {
	while (MyList->prev != NULL) {
		Write *temp = MyList->prev->next;
		delete MyList->prev;
		MyList->prev = temp;
	}
}

int main() {

	Write *obj = new Write;

	obj->prev = NULL;
	int k = 0,c;

	cout << "1 - Add element" << endl << "2 - Delete elements" << endl << "3 - Show elemets" << endl;
	cout << "4 - Show memory" << endl << "5 - Exit" << endl;
	cin >> c;

	while (c != 5) {
		switch (c) {
		case 1:
			int x;
			cout << "Add" << endl;
			cin >> x;
			Add(x, obj);
			k++;
			cout << "Choose from 1 to 6" << endl;
			break;
		case 2:
			Clear(obj);
			k = 0;
			cout << "Choose from 1 to 6" << endl;
			break;
		case 3:
			Show(obj);
			cout << "Choose from 1 to 6" << endl;
			break;
		case 4:
			cout << "Memory: " << k*sizeof(obj) << endl;
			cout << "Choose from 1 to 6" << endl;
			break;
		};
		cin >> c;
	}

	delete obj->prev;
	delete obj;

	return 0;
}