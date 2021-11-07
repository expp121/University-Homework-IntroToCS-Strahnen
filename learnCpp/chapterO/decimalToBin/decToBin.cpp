#include <iostream>
#include <string>

int main()
{
    uint8_t num;
    std::cout << "Enter a number between 0 and 255: ";
    std::cin >> num;
    std::string result("");
    while (num > 1)
    {
        if (num % 2 == 0)
        {
            result = '0' + result;
        }
        else
            result = '1' + result;
    }
}