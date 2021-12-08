/**
 * @file article.h  
 * @author Dimitar Banchev
 * @brief Class which extends the main Medium class, adding 3 new fields(Magazine name, number, page number)
 * @version 0.1
 * @date 2021-12-08
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#pragma once
#include "medium.h"
class Article : virtual public Medium
{
private:
    std::string magazineName;
    unsigned int magazineNumber;
    unsigned int pageNumber;

public:
    /**
     * @brief Construct a new Article object
     * Default constructor, which initialises to default values
     */
    Article();
    /**
     * @brief Construct a new Article object
     * Constructor with a given value
     * @param abbreviation - Abreviation of the article
     * @param author - The author of the aritcle
     * @param title - The title of the articles
     * @param yearOfPublication - Which year the article was published
     * @param magazineName - The name of the magazine, containing the article
     * @param magazineNumber - Magazine number
     * @param pageNumber - The page number of the article
     */
    Article(const std::string abbreviation, const std::string author,
            const std::string title, const unsigned int yearOfPublication,
            const std::string magazineName, const unsigned int magazineNumber, const unsigned int pageNumber);
   
   virtual ~Article();
    /**
     * @brief Set the Magazine Name object
     * 
     * @param magazineName 
     */
    void setMagazineName(std::string magazineName);

    /**
     * @brief Set the Magazine Number object
     * 
     * @param magazineNumber 
     */
    void setMagazineNumber(unsigned int magazineNumber);
    /**
     * @brief Set the Page Number object
     * 
     * @param pageNumber 
     */
    void setPageNumber(unsigned int pageNumber);

    /**
     * @brief Get the Magazine Name object
     * 
     * @return std::string 
     */
    std::string getMagazineName();

    /**
     * @brief Get the Magazine Number object
     * 
     * @return unsigned int 
     */
    unsigned int getMagazineNumber();
    /**
     * @brief Get the Page Number object
     * 
     * @return unsigned int 
     */
    unsigned int getPageNumber();
    /**
     * @brief Custom toString method, overriding the Medium class 
     * 
     * @return std::string 
     */
    std::string toString() const override;
};