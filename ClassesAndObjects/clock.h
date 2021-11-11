class Clock
{
private:
    long ticks;

public:
    bool tick();
    bool tick(int n);
    void displayTime();
    bool setTime(char hours, char minutes, char seconds);

    Clock(/* args */);
    ~Clock();
};
