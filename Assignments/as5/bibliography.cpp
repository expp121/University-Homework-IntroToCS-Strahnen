#include "bibliography.h"

Bibliography::Bibliography(unsigned int size) : size{size}, numOfItems(0), library(new Medium *[size]) {}

/**
 * @brief Destroy the Bibliography:: Bibliography object
 * Clean up the allocated memory from the array
 */
Bibliography::~Bibliography()
{
    delete[] library;
}

bool Bibliography::insert(Book *data)
{
    /**
     * @brief 
     * Check for available space and if the passed data is not null and then insert
     */
    if (this->numOfItems < this->size)
    {
        if (data)
        {
            this->library[this->numOfItems] = data;
            this->numOfItems++;
            return true;
        }
    }
    return false;
}
bool Bibliography::insert(Article *data)
{

    if (this->numOfItems < this->size)
    {
        if (data)
        {
            this->library[this->numOfItems] = data;
            this->numOfItems++;
            return true;
        }
    }
    return false;
}
Medium *Bibliography::operator[](const std::string abbreviation)
{
    /**
     * @brief Loop through the initialised elements of the libraty
     * and return if a match is found
     */
    for (size_t i = 0; i < this->numOfItems; i++)
        if (this->library[i]->getUniqueAbbreviation() == abbreviation)
            return this->library[i];
    return nullptr;
}

std::ostream &operator<<(std::ostream &output, const Bibliography &lib)
{
    output << '(';
    for (size_t i = 0; i < lib.numOfItems; i++)
    {
        if (i != lib.numOfItems - 1)
        {
            output << lib.library[i]->toString() << ',';
            continue;
        }
        output << lib.library[i]->toString() << ')';
    }
    return output;
}