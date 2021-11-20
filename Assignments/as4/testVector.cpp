#include "vector.h"
#include <iostream>


int main(){

    Vector v;
    Vector *n = new Vector(5,5.5);
    Vector * vp = new Vector(2,1.1);
    Vector * vpd = new Vector(4,0.0);
    Vector vc(*vp);

    std::cout<< *n;
    std::cout<<(*vp)[1];//works
    vp = n;
    (*n).set(3,1.2);//works
    std::cout<<n->get(3);//workds


}