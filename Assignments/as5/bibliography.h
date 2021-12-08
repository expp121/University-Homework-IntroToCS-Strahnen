/**
 * @file bibliography.h 
 * @author Dimitar Banchev
 * @brief Combines the Article and Book classes into one 'Library'
 * @version 0.1
 * @date 2021-12-08
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#include "article.h"
#include "book.h"
#include <ostream>
class Bibliography //: public Article, public Book
{
private:
    unsigned int size;
    unsigned int numOfItems;
    /**
     * @brief 
     * Holds array of pointers to Medium pointers 
     */
    Medium **library;

public:
    /**
     * @brief Construct a new Bibliography object
     * 
     * @param size - How many objects the Bibliography will contain
     */
    Bibliography(unsigned int size = 1);
    ~Bibliography();
    /**
     * @brief Overloaded method to insert childs of the Medium class
     * 
     * @param data - Data to be inserted
     * @return true - Succesfully inserted
     * @return false - Not enough space to insert element
     */
    bool insert(Book* data);
     /**
     * @brief Overloaded method to insert childs of the Medium class
     * 
     * @param data - Data to be inserted
     * @return true - Succesfully inserted
     * @return false - Not enough space to insert element
     */
    bool insert(Article* data);
    /**
     * @brief Overload the default operator '[]', so we can get elements by their abbriviation,
     * Example:
     * library['abrv'] - returns a pointer to the object with abbreviation 'abrv'  
     * 
     * @param abbreviation
     * @return Medium* - Pointer to the object with that abbreviation, or a null pointer if there is no
     * object with this abbreviation
     */
    Medium *operator[](const std::string abbreviation);
    /**
     * @brief Overloads the '<<' operator, so it return the content of the library, separated by commas
     * Example:
     * (obj,obj,obj)
     * 
     * @param output 
     * @param lib 
     * @return std::ostream& 
     */
    friend std::ostream &operator<<(std::ostream &output, const Bibliography &lib);
    //std::string toString() const override;
};