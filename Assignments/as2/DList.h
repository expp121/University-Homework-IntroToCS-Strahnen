/**
 * @file DList.h    
 * @author expp (Dimtiar)
 * @brief My, probably very bad implementation of doubly linked list, 
 * which supports deleting the last element, inserting a new element
 * in the first's element postition
 * and a check if the list is empty
 * @version 0.1
 * @date 2021-11-03-2021-11-04
 * 
 * @copyright Copyright (c) 2021
 * 
 */

/**
 * @brief That's how a node or an element from the list is represented,
 * having a variable to store the data,
 * and two pointers, pointing to the next node and the previous
 */
struct DListElem
{
    int data;
    DListElem *next;
    DListElem *previous;
};

/**
 * @brief The start node and the end node are wrapped in one
 * structure, a.k.a List
 */
struct DList
{
    DListElem *start;
    DListElem *end;
};

/**
 * @brief Initializes the list with empty value
 * @param dl - The list to be initialized
 */
void initializeDList(DList &dl);

/**
 * @brief Puts an element into the first place of the given List
 * @param dl - In which list to put the element
 * @param val - What's the value, that's going to be inserted
 */
void put(DList &dl, int val);

/**
 * @brief Removes the last element of the List
 * 
 * @param dl - The list to remove elements from
 * @param val - The removed value will be stored here, just in case you need it
 * @return true - An element was succesfully removed
 * @return false - The list is empty
 */
bool get(DList &dl, int &val);

/**
 * @brief Checks if the given list is empty
 * @param dl - The list to check
 * @return true - The list is empty
 * @return false - The list has at least 1 element
 */
bool isEmpty(DList dl);
