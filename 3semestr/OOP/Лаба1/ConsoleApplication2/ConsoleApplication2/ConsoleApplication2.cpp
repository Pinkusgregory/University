// ConsoleApplication1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include "string"
#include "iostream"

using namespace std;

class Marsh {
private:
	string start, end;
	int number;
public:
	void StartName(Marsh x, Marsh y);
	void InputMarsh();
	void OutputMarsh();
};

void Marsh::StartName(Marsh x, Marsh y) {
	if ((x.start == y.start) && (x.number != y.number)) {
		cout << "Correct" << endl;
	}
	else {
		cout << "Incorrect" << endl;
	}
}

void Marsh::InputMarsh() {
	cin >> start >> end >> number;
}

void Marsh::OutputMarsh() {
	cout << "Start Marsh " << start << endl;
	cout << "End Marsh " << end << endl;
	cout << "Number Marsh " << number << endl;
}

int main()
{
	Marsh Marsh1, Marsh2;
	cout << "Enter start,end and number of 1st marsh" << endl;
	Marsh1.InputMarsh();
	cout << "Enter start,end and number of 2nd marsh" << endl;
	Marsh2.InputMarsh();
	Marsh1.OutputMarsh();
	Marsh2.OutputMarsh();
	Marsh1.StartName(Marsh1,Marsh2);
	return 0;
}

