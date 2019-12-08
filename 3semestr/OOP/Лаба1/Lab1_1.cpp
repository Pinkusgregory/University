#include <iostream>
#include <cstdlib>

using namespace std;

struct Marsh {
	string start,end;
	int number;
};

void StartName (Marsh x, Marsh y){
	if ((x.start==y.start)&&(x.number!=y.number)) {
		cout << "Correct"<< endl;
	}
	else {
		cout << "Incorrect"<< endl;
	}
}

Marsh InputMarsh(){
	Marsh x;
	cin >> x.start >> x.end >> x.number;
	return x;
}

void OutputMarsh(Marsh x){
	cout << "Start Marsh " << x.start << endl;
	cout << "End Marsh " << x.end << endl; 
	cout << "Number Marsh " << x.number << endl;
}

int main(){
	Marsh Marsh1,Marsh2;
	cout <<"Enter start,end and number of 1st marsh" << endl;
	Marsh1 = InputMarsh();
	cout <<"Enter start,end and number of 2nd marsh"<< endl;
	Marsh2 = InputMarsh();
	OutputMarsh(Marsh1);
	OutputMarsh(Marsh2);
	StartName(Marsh1,Marsh2);
	return 0;
}

