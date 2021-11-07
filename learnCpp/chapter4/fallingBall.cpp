#include <iostream>

int main()
{

    std::cout << "Enter the height of the tower in meters: ";
    double towerHeight;
    std::cin >> towerHeight;

    for (size_t i = 0; i <= 10; i++)
    {
        std::cout << "At " << i << " seconds, the ball is ";
        if ((towerHeight - (9.8 * ((i * i) / 2.0))) > 0)
            std::cout << "at height: " << (towerHeight - (9.8 * ((i * i) / 2.0))) << "\n";

        else
            std ::cout << "on the ground\n";
    }

    return 0;
}