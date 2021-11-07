#include <iostream>

int main()
{

    char c;
    std::cout << "Enter a character: ";
    std::cin >> c;
    std::cout << "You entered '" << c << "', which has ASCII code " << static_cast<int>(c) << "\n";

    return 0;
}