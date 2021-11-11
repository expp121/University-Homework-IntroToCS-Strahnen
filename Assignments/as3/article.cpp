#include "article.h"

/**
 * @brief Get the number of articles
 * 
 * @return int Num of Articles
 */
int Article::getNumberOfArticles()
{
    return numberOfArticle;
}

std::string Article::getDescription()
{
    return description;
}

double Article::getCost()
{
    return costPrice;
}
int Article::getOrderDuration()
{
    return orderDuration;
}
void Article::setNumArticles(int numOfArticles)
{
    this->numberOfArticle = numOfArticles;
}
void Article::setDescription(std::string description)
{
    this->description = description;
}
void Article::setCostPrice(double cost)
{
    this->costPrice = cost;
}
void Article::setOrderDuration(int orderDuration)
{
    this->orderDuration = orderDuration;
}
Article::Article(int numOfArticles, std::string description, double costPrice, int orderDuration)
{
    this->numberOfArticle = numOfArticles;
    this->description = description;
    this->costPrice = costPrice;
    this->orderDuration = orderDuration;
}
Article::Article(std::string data[4])
{
    this->numberOfArticle = stoi(data[0]);
    this->description = data[1];
    this->costPrice = stod(data[2]);
    this->orderDuration = stoi(data[3]);
}