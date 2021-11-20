#include <iostream>

int main()
{
    char c('a');
    while (c <= 'z')
    {
        std::cout << c << " " << (int)c << "\n";
        c++;
    }
    return 0;
    
}