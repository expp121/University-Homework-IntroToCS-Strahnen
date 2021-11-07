#include <iostream>

#include "counter.h"

using namespace std;

int main()
{
    Counter c1, c2;
    c1.setCounter(1);
    c2.setCounter(2);

    c1.raise();
    c1.raise();
    c2.raise();
    c2.raise();
    c1.raise();
    c1.raise();
    c2.raise();
    c1.raise();

    cout << c1.getCounter() << endl
         << c2.getCounter() << endl;

    cin.sync();
    cin.get();
    return 0;
}
