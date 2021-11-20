#include "vector.h"
#include <iostream>

Vector::Vector(const Vector &obj) : dimension(2)
{
    if (&obj != NULL)
    {
        this->dimension = obj.dimension;
        this->data = new double[this->dimension];
        for (int i = 0; i < this->dimension; i++)
            this->data[i] = obj.data[i];
    }
}

Vector::Vector(int dimension, double defaultElementVal) : dimension(2)
{
    if (dimension > 0)
    {
        this->dimension = dimension;
        this->data = new double[this->dimension];
    }
    else
    {
        this->data = new double[2];
        this->dimension = 2;
    }

    for (int i = 0; i < dimension; i++)
        data[i] = defaultElementVal;
}

Vector::~Vector()
{
    delete[] data;
}

Vector &Vector::operator=(const Vector &obj)
{
    if (this->dimension < obj.dimension)
    {
        delete[] data;
        this->dimension = obj.dimension;
        this->data = new double[this->dimension];
    }
    for (int i = 0; i < obj.dimension; i++)
        this->data[i] = obj.data[i];

    return *this;
}

double &Vector::operator[](const int index)
{
    if (index >= this->dimension || index < 0)
    {
        std::cout << "Index out of bounds, tried to access element with index: " << index << ", returning first element...\n";
        exit(1);
    }
    return this->data[index];
}

bool Vector::set(int index, double value)
{
    if (this->dimension > index)
    {
        this->data[index] = value;
        return true;
    }
    else
        return false;
}

double Vector::get(int index)
{
    if (this->dimension > index)
        return this->data[index];
    else
        return NULL;
}

std::ostream &operator<<(std::ostream &output, const Vector &obj)
{
    output << '(';
    for (int i = 0; i < obj.dimension; i++)
    {
        if (i != obj.dimension - 1)
        {
            output << obj.data[i] << ', ';
            continue;
        }
        output << obj.data[i];
    }
    output << ')';
    return output;
}
