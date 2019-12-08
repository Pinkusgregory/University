#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <iomanip>
#include <stdlib.h>

using namespace std;

class MyFile
{
private:
	string path;
public:
	MyFile()
	{
		path = "";
	}
	void InputPath()
	{
		cout << "Enter path to file" << endl;
		cin >> path;
	}
	string GetPath()
	{
		return path;
	};
};

string inBinary(int num) 
{
	int copy, a = 0;
	string str, result;
	while (num != 0) 
	{
		copy = num;
		copy = copy / 2;
		a = num % 2;
		num = copy;
		str += to_string(a);
	}
	for (int i = str.length() - 1;i >= 0;i--) 
	{
		result += str[i];
	}
	return result;
}

int main()
{
	string path;
	fstream file;
	MyFile ob;
	int i = 1;
	char start_symb;
	char in_symb;
	ob.InputPath();
	path = ob.GetPath();
	file.exceptions(fstream::badbit | fstream::failbit);
	try
	{
		cout << "Trying to open the file" << endl;
		file.open(path, ios::in | ios::out | ios::trunc);
		cout << "File opened successfully" << endl;
		cout << "Enter the Symbol from a to z: " << endl;
		cin >> in_symb;
		if (in_symb<'a' || in_symb>'z') 
		{
			throw exception("Invalid character entered");
		}
		else 
		{
			for (start_symb = 'a'; start_symb <= in_symb; start_symb++) {
				file << i << " - " << start_symb << "\t 10:" << dec << int(start_symb);
				file << "\t 16:" << hex << int(start_symb);
				file << "\t 8:" << oct << int(start_symb);
				file << "\t 2:" << inBinary(int(start_symb)) << endl;
				i++;
			}
			file.close();
			cout << "Data is located in the file" << endl;
		}
	}
	catch (const fstream::failure & ex)
	{
		cout << ex.what() << endl;
		cout << ex.code() << endl;
		cout << "Error in opening file" << endl;
	}
	catch (const exception &ex)
	{
		cout << ex.what() << endl;
	}
	return 0;
}