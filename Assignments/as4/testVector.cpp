/**
 * @file testVector.cpp
 * @author Dimitar Banchev
 * @brief A test programm for the vector class
 * @version 0.1
 * @date 2021-11-20
 * 
 * @copyright Copyright (c) 2021
 * 
 */

#include "vector.h"
#include <iostream>


int main(){

    Vector v;
    Vector *n = new Vector(5,5.5);
    Vector * vp = new Vector(2,1.1);
    Vector * vpd = new Vector(4,0.0);
    Vector vc(*vp);

    /**
     * @brief Test the '<<' operator
     */
    std::cout<< *n; // works

    /**
     * @brief Test the '[]' operator
     */
    std::cout<<(*vp)[1];//works

    /**
     * @brief Test the '=' operator
     */
    vp = n;

    /**
     * @brief Test the set function
     */
    (*n).set(3,1.2);//works

    /**
     * @brief Test the get function
     */
    std::cout<<n->get(3);//workds


}