#include <iostream>

int main()
{
    std::cout << "Enter a integer: ";
    int num{};
    std::cin >> num;
    std::cout << "Double " << num << " is: " << 2 * num << "\nTripple " << num << " is: " << num * 3 << "\n";

    return 0;
}