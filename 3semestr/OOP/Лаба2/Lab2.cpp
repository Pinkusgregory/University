#include <string>
#include <iostream>

using namespace std;

class Line;

class Symbol {
protected:
	char symb;
public:
	Symbol(char _symb) { symb = _symb; };
	Symbol() { cout << "Enter symbol" << endl; cin >> symb; };
	char GetSymb() { return symb; };
	virtual void Output() = 0;
	virtual ~Symbol(){ cout << "Symbol Destuctor" << endl; };
	virtual void Include(Line x) = 0;
};

class Line: public Symbol {
protected:
	string word;
public:
	Line(char _symb) : Symbol(_symb) {};
	Line() : Symbol() { cout << "Enter word= " << endl; cin >> word; };
	Line(string _word) { word = _word; };
	virtual void Output() { cout << "Word=" << word << endl; };
	virtual void Include(Line x);
	virtual ~Line(){ cout << "Line Destuctor" << endl; };
};

class Number: public Symbol{
protected:
	int numb;
public:
	Number() : Symbol() { cout << "Enter number=" ; cin >> numb; }
	virtual void Output(){ cout << "Number=" << numb << endl; }
	virtual ~Number(){ cout << "Number Destuctor" << endl; };
};

void Line::Include(Line x) {
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
	Symbol *object1 = new Line;
	object1->Output();
	object1->Include(object1);
	delete object1;
	Symbol *object2 = new Number;
	object2->Output();
	delete object2;
    return 0;
}


