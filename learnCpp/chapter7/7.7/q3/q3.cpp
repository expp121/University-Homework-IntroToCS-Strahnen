#include <iostream>

int main()
{
    char i = 5;

    while (i > 0)
    {
        char j = i;
        while (j > 0)
        {
            std::cout << (int)j << " ";
            --j;
        }
        std::cout << "\n";
        --i;
    }

    return 0;
}