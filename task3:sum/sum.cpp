#include <iostream>
#include <cstddef>
using namespace std;

#define PRODUCT_1(a, b) ((a) * (b))
#define PRODUCT_2(a, b) a * b

int main()
{
    short sum = 0;
    for (char i = -10; i < 10; i++)
        sum += i;

    cout << sum << endl;
    cout << 2 * PRODUCT_1(2 + 1, 3) << endl;
    cout << 2 * PRODUCT_2(2 + 1, 3) << endl;
}