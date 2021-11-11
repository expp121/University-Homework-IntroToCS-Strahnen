/**
 * @file stock.h
 * @author Dimitar Banchev
 * @brief Header file for the Stock class
 * @version 0.1
 * @date 2021-11-11
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#include <string>
class Stock
{
private:
    int articleNumber;
    int actualStock;
    int maximumStock;
    int consumption;

public:
    int getArticleNumber();
    int getActualstock();
    int getMaximumStock();
    int getConsumption();
    void setArticleNumber(int articleNumber);
    void setActualStock(int actualStock);
    void setMaximumStock(int maximumStock);
    void setConsumption(int consumption);
    Stock(int articleNumber, int actualStock, int maximumStock, int consumption);
    Stock(std::string data[4]);

    ~Stock();
};