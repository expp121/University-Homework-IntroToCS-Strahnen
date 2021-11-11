/**
 * @file article.h
 * @author Dimitar Banchev 
 * @brief Header file for the Article class
 * @version 0.1
 * @date 2021-11-11
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#include <string>

class Article
{
private:
    int numberOfArticle;
    std::string description;
    double costPrice;
    int orderDuration;

public:
    int getNumberOfArticles();
    std::string getDescription();
    double getCost();
    int getOrderDuration();

    void setNumArticles(int numOfArticles);
    void setDescription(std::string description);
    void setCostPrice(double cost);
    void setOrderDuration(int orderDuration);
    Article(int numOfArticles, std::string description, double costPrice, int orderDuration);
    Article(std::string data[4]);
    ~Article();
};