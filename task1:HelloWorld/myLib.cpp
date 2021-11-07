#include <iostream>

using namespace std;

void drawLine()
{
    cout << "--------------------" << endl; 
}

void saySomething()
{
    cout << "Hello" << endl;
}


/*
WAYS TO COMPILE
1. g++ *.cpp -Wall -g -o [programm name]


2.Making object files and linking them manually
g++ -c [file name].cpp -Wall -g -o [filename].o - for every file
g++ -c main.cpp -Wall -g -o main.o

g++ [objectfiles].o -Wall -g -o [programm]
g++ main.o myLib.o -Wall -g -o myProgram
OR
g++ *.o -Wall -g -o myProgram
*/