#include <iostream>
#define QSUMME(a, b) ((a) * (a) + (b) * (b))

int main()
{
    int i1 = 3;
    int i2 = 2;                         // Ergebnis:
    std::cout << QSUMME(i1, i2) << std::endl;     // 13
    std::cout << QSUMME(2 + i1, i2) << std::endl; // 29
    std::cout << QSUMME(i1, i2 + 1) << std::endl; // 18
    std::cout << 3 * QSUMME(i1, i2) << std::endl; // 39

    return 0;
}