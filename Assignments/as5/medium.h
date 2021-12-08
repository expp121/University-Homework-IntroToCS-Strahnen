/**
 * @file medium.h
 * @author Dimitar Banchev
 * @brief A base class for Article,Book, which holds an abbreviation for the medium, 
 * who made it, it's title and when it was published 
 * @version 0.1
 * @date 2021-12-08
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#pragma once
#include <string>
class Medium
{
private:
    std::string uniqueAbbreviation;
    std::string author;
    std::string title;
    unsigned int yearOfPublication;

public:
    /**
     * @brief Construct a new Medium object from a given values
     * 
     * @param abbreviation 
     * @param author 
     * @param title 
     * @param yearOfPublication 
     */
    Medium(const std::string abbreviation, const std::string author, const std::string title, const unsigned int yearOfPublication);
    /**
     * @brief Construct a new Medium object with default values
     * 
     */
    Medium();
    virtual ~Medium();
    /**
     * @brief Set the Unique Abbreviation of object
     * 
     * @param abbreviation 
     */
    void setUniqueAbbreviation(std::string abbreviation);
    /**
     * @brief Set the Author of object
     * 
     * @param author 
     */
    void setAuthor(std::string author);
    /**
     * @brief Set the Title of object
     *
     * @param title 
     */
    void setTitle(std::string title);
    /**
     * @brief Set the Year Of Publication of object
     * 
     * @param year 
     */
    void setYearOfPublication(unsigned int year);

    /**
     * @brief Get the Unique Abbreviation of object
     * 
     * @return std::string 
     */
    std::string getUniqueAbbreviation();
    /**
     * @brief Get the Author of object
     * 
     * @return std::string 
     */
    std::string getAuthor();
    /**
     * @brief Get the Title of object
     * 
     * @return std::string 
     */
    std::string getTitle();
    /**
     * @brief Get the Publication Year of object
     * 
     * @return unsigned int 
     */
    unsigned int getPublicationYear() const;

    virtual std::string toString() const;
};
