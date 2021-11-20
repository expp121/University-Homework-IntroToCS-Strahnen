#include <ostream>
class Vector
{
private:
    int dimension;
    double * data;
public:
    Vector(int dimension = 2, double defaultElementVal = 0.0);
    Vector(const Vector& obj);
    ~Vector();
    bool set(int index, double value);
    double get(int index);
    double& operator[](int index);
    Vector& operator = (const Vector& obj);
    friend std::ostream& operator << (std::ostream &output, const Vector& obj);
};

