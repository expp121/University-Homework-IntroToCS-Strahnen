/**
 * @file book.h
 * @author Dimitar Banchev
 * @brief Derivative of the Medium class, which is adding 1 new field: publisher
 * @version 0.1
 * @date 2021-12-08
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#pragma once
#include "medium.h"

class Book : virtual public Medium
{
private:
    std::string publisher;

public:
    /**
     * @brief Construct a new Book object with default values
     * 
     */
    Book();
    /**
     * @brief Construct a new Book object with given values
     * 
     * @param abbreviation 
     * @param author 
     * @param title 
     * @param yearOfPublication 
     * @param publisher 
     */
    Book(const std::string abbreviation, const std::string author,
         const std::string title, const unsigned int yearOfPublication, std::string publisher);
    virtual ~Book();
    /**
     * @brief Set the Publisher of the object
     * 
     * @param publisher 
     */
    void setPublisher(std::string publisher);
    /**
     * @brief Get the Publisher of the object
     * 
     * @return std::string 
     */
    std::string getPublisher();
    std::string toString() const override;
};
