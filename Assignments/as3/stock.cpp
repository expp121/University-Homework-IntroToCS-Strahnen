#include "stock.h"
int Stock::getArticleNumber()
{
    return this->articleNumber;
}
int Stock::getActualstock()
{
    return this->actualStock;
}
int Stock::getMaximumStock()
{
    return this->maximumStock;
}
int Stock::getConsumption()
{
    return this->consumption;
}
void Stock::setArticleNumber(int articleNumber)
{
    this->articleNumber = articleNumber;
}
void Stock::setActualStock(int actualStock)
{
    this->actualStock = actualStock;
}
void Stock::setMaximumStock(int maximumStock)
{
    this->maximumStock = maximumStock;
}
void Stock::setConsumption(int consumption)
{
    this->consumption = consumption;
}
Stock::Stock(int articleNumber, int actualStock, int maximumStock, int consumption)
{
    this->articleNumber = articleNumber;
    this->actualStock = actualStock;
    this->maximumStock = maximumStock;
    this->consumption = consumption;
}
/**
 * @brief Construct a new Stock:: Stock object
 * Initializes every field of the class with the given data
 * @param data 
 * first element corresponds to articleNumber
 * second element to actualStock
 * third element to maximumStock
 * forth element to consumption
 */
Stock::Stock(std::string data[4])
{
    this->articleNumber = stoi(data[0]);
    this->actualStock = stoi(data[1]);
    this->maximumStock = stoi(data[2]);
    this->consumption = stoi(data[3]);
}