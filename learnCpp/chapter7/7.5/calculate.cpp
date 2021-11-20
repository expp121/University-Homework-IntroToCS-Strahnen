#include <iostream>

double calculate(int num1, int num2, char mathOperator)
{
    double result(0.0);
    switch (mathOperator)
    {
    case '+':
        result = num1 + num2;
        break;
    case '-':
        result = num1 - num2;
        break;
    case '/':
        result = (int)(num1 / num2);
        break;
    case '*':
        result = num1 * num2;
        break;
    case '%':
        result = num1 % num2;
        break;

    default:
        std::cout << "Invalid operation!\n";
        break;
    }
    return result;
}

int main()
{
    int i(9);
    int j(5);
    std::cout << i << " + " << j << " = " << calculate(i, j, '+') << "\n"
              << i << " - " << j << " = " << calculate(i, j, '-') << "\n"
              << i << " / " << j << " = " << calculate(i, j, '/') << "\n"
              << i << " % " << j << " = " << calculate(i, j, '%') << "\n"
              << i << " * " << j << " = " << calculate(i, j, '*') << "\n";
}