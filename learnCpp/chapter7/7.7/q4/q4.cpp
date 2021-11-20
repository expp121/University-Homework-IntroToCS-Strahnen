#include <iostream>

int main()
{
    char c(5);

    while (c > 0)
    {

        char whiteSpace(c - 1);

        while (whiteSpace > 0)
        {
            std::cout << "  ";
            --whiteSpace;
        }
        char num(6 - c);
        while (num > 0)
        {
            std::cout << (int)num << " ";
            --num;
        }
        std::cout << '\n';

        --c;
    }

    return 0;
}