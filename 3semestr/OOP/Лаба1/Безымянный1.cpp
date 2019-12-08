#include <string>
#include <iostream>

using namespace std;

class Symbol {
protected:
	char symb;
public:
	Symbol(char _symb) { symb = _symb; };
	Symbol() { cout << "Enter symbol" << endl; cin >> symb; };
	char GetSymb() { return symb; };
	void Output() { cout << "Symbol= " << GetSymb() << endl; };
};

class Line: public Symbol {
protected:
	string word;
public:
	//Line(string _word) : Symbol(_symb) { word = _word; };
	Line() : Symbol() { cout << "Enter word= " << endl; cin >> word; };
	//Line(string _word) { word = _word; };
	//Line(){ cout << "Enter word= " << endl; cin >> word; };
	void Output() { cout << "Word=" << word << endl; };
	void Include(Symbol x);
};

void Line::Include(Symbol x) {
	int i, k = 0;
	char y = x.GetSymb();
	while (word[i] != '\0') {
		if (word[i] == y) {
			k = 1;
		}
		i++;
	};
	if (k == 1) {
		cout << "Word includes symb" << endl;
	}
	else {
		cout << "Word doesnt include symb" << endl;
	};
};

int main()
{
	Symbol Symbol1('q');
	Line Line1;
	Symbol1.Output();
	Line1.Output();
	Line1.Symbol::Output();
	Line1.Include(Symbol1);
    return 0;
}


