//Aufg_2_2.cpp: Rekursive Datentypen, einfach verkettete Liste
#include <iostream>
#include "List.h"
using namespace std;

int main()
//-----------------------------------------------------------
// test for  insertLast(), printList() and reverseList()
//-----------------------------------------------------------
{
  // fill List with values 1 to 10
  List list1 = emptyList;
  for (int value = 1; value <= 10; value++)
  {
    //insertElem( list1, value ); 
    insertLast( list1, value );
  }

  //print list
  printList(list1);  // should provide sequence 1 2 3 ... 10 

  // produce list in reverse order
  reverseList(list1);

  // print list
  printList(list1);  // should provide sequence  10 9 8 ... 1 

  cin.sync(); cin.get();
}

