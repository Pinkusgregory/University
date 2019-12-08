#include <iostream>
#include <cstdlib>

using namespace std;

class Marsh {
	string start,end;
	int number;
public:
	void InputMarsh();
	void OutputMarsh();
	void StartName(Marsh x,Marsh y);
};

void Marsh::StartName (Marsh x, Marsh y){
	if ((x.start==y.start)&&(x.number!=y.number)) {
		cout << "Correct"<< endl;
	}
	else {
		cout << "Incorrect"<< endl;
	}
}	
void Marsh::InputMarsh(){
	cout << "Enter Start Marsh " << endl;
	cin >> start;
	cout << "Enter End Marsh " << endl;
	cin >> end;
	cout << "Enter Number Marsh " << endl;
	cin >> number;
}
	
void Marsh::OutputMarsh(){
	cout << "Start Marsh " << start << endl; 
	cout << "End Marsh " << end << endl;
	cout << "Number Marsh " << number << endl;
}

int main(){
	Marsh Marsh1,Marsh2;
	cout << "Enter 1st Marsh:" << endl;
	Marsh1.InputMarsh();
	cout << "Enter 2nd Marsh:" << endl;
	Marsh2.InputMarsh();
	Marsh1.StartName(Marsh1,Marsh2);
	cout << "1st Marsh:" << endl;
	Marsh1.OutputMarsh();
	cout << "2nd Marsh:" << endl;
	Marsh2.OutputMarsh();
	return 0;
}
