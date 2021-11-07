#include <iostream>
#include "counter.h"

using namespace std;

void Counter::raise()
{
    count++;
}

void Counter::reset()
{
    count = 0;
}

void Counter::print()
{
    cout << "Counter: " << count << endl;
}

int Counter::getCounter(){
    return count;
}

void Counter::setCounter(int value)
{
    this->count = value;
}
