#include <iostream>
#include <string>

int main()
{
    double num1, num2;
    std::cout << "Enter a double number: ";
    std::cin >> num1;
    std::cout << "Enter a double number: ";
    std::cin >> num2;
    std::cout << "Enter one of the following +, -, *, or / : ";
    char choice;
    std::cin >> choice;
    switch (choice)
    {
    case '+':
        std::cout << num1 << " + " << num2 << " is " << num1 + num2 << "\n";
        break;
    case '-':
        std::cout << num1 << " - " << num2 << " is " << num1 - num2 << "\n";
        break;
    case '*':
        std::cout << num1 << " * " << num2 << " is " << num1 * num2 << "\n";
        break;
    case '/':
        std::cout << num1 << " / " << num2 << " is " << num1 / num2 << "\n";
        break;

    default:
        std::cout << "Invalid choice!\n";
        break;
    }

    return 0;
}