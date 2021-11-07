#include <iostream>
#include <cmath>
double f(double x)
{
    return exp(-(x * x));
}

double integral(double a, double b, int n)
{
    double partitionWidth = (b - a) / n;
    double result = 0.0;
    result += 0.5 * f(a) + 0.5 * f(b);
    for (int i = 1; i < n; i++)
    {
        result += f(a + i*partitionWidth);
    }
    result *= partitionWidth;
    return result;
}

int main()
{
    std::cout << integral(0,1,1000) << "\n";
    return 0;
}