/*
    Write a complete program that reads an integer from the user, 
    doubles it using the doubleNumber() function you wrote in the previous quiz question, 
    and then prints the doubled value out to the console.
*/
#include "func2.3-Q4.h"

int readInput()
{
    int input(0);
    std::cout << "Enter an integer: ";
    std::cin >> input;
    return input;
}

int main()
{
    int d = doubleNumber(readInput());
    std::cout << "Your number doubled is: " << d << "\n";
    return 0;
}
