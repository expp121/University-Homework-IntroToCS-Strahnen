#include <iostream>
#include "clock.h"

void Clock::displayTime()
{
    std::cout<<"";
}

bool Clock::setTime(char hours, char minutes, char seconds)
{
    this->ticks = hours * (60 * 60) + minutes * 60 + seconds;
}

bool Clock::tick()
{
    tick(1);
}
bool Clock::tick(int n)
{
    this->ticks = (this->ticks + n) % (24 * 60 * 60);
}

Clock::Clock(/* args */)
{
}

Clock::~Clock()
{
}