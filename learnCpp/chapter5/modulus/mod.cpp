#include <iostream>

bool isEven(const int num)
{

    return !(num % 2);
}

int main()
{

    std::cout << "Enter a number: ";
    int num;
    std::cin >> num;
    std::cout << num << " is " << (isEven(num) ? "even" : "odd");
}