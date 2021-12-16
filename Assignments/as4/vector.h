/**
 * @file vector.h 
 * @author Dimitar Banchev
 * @brief A class which implements a vector with a static size(changes size if assigned to another vector) and also setting and getting an element from it
 * @version 0.1
 * @date 2021-11-20
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#include <ostream>
class Vector
{
private:
    /**
     * @brief The lenght of the vector
     */
    int dimension;
    
    /**
     * @brief An array of size 'dimension', holding the elements
     * 
     */
    double * data;
public:

    /**
     * @brief Construct a new Vector object
     * 
     * @param dimension - The lenght of the vector(how many elements it has)
     * @param defaultElementVal - The default value of all the elements when creating the object
     */
    Vector(int dimension = 2, double defaultElementVal = 0.0);

    /**
     * @brief Construct a new Vector object with the same size as the argument vector,
     * and also has the same elements as the given vector
     * @param obj - The object which will be 'copied'
     */
    Vector(const Vector& obj);

    /**
     * @brief Free up the allocated array memory
     */
    ~Vector();
    /**
     * @brief Sets an element to a given value
     * 
     * @param index - The index of the element which will be set
     * @param value - The value that will be given to the element which is being set
     * @return true - The function succesfully has set the value
     * @return false - The given index is out of bounds
     */
    bool set(int index, double value);
    
    /**
     * @brief Gets a value corresponding to the given index
     * @param index
     * @return double 
     */
    double get(int index);

    /**
     * @brief Overloads the '[]' operator, so we can get elements from the vector just by typing 'v[indx]',
     * instead of using 'v.get(indx)'
     * @param index - The index of the element
     * @return double& 
     */
    double& operator[](int index);
    
    /**
     * 
     * @brief Overloads the '=' operator, so that we can do a 'hard copy' of the object to another one
     * @param obj - The object which will be copied
     * @return Vector& 
     */
    Vector& operator = (const Vector& obj);

    /**
     * @brief Returns a stream containing all of the elements in the vector divided by comma,
     * so we can get all of the elements of the vector
     * Example return:
     *  (1.2, 3.4, 0.5)
     * @param output 
     * @param obj 
     * @return std::ostream& 
     */
    friend std::ostream& operator << (std::ostream &output, const Vector& obj);
};

