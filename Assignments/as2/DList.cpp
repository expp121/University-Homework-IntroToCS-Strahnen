#include "DList.h"
#include <iostream>


void initializeDList(DList &dl)
{
    /**
     * @brief Check if there is reserved memory for the list 
     * If yes, assign the start and the end to NULL
     */
    if (&dl)
    {
        (&dl)->start = NULL;
        (&dl)->end = NULL;
    }
}
void put(DList &dl, int val)
{
    /**
     * @brief Element insertion for empty list
     */
    if (!((&dl)->start))
    {
        (&dl)->start = new DListElem;
        (&dl)->end = (&dl)->start;
        (&dl)->start->data = val;
    }
    else
    {
        /**
         * @brief Element insertion for non empty list
         */
        DListElem *newElement = new DListElem;
        newElement->data = val;
        newElement->next = (&dl)->start;
        (&dl)->start->previous = newElement;
        (&dl)->start = newElement;
    }
}
bool get(DList &dl, int &val)
{
    /**
     * @brief Check for empty List
     */
    if (!((&dl)->end))
        return false;

    else
    {
        /**
         * @brief Get the data stored in the last element of the list
         */
        val = (&dl)->end->data;

        /**
         * @brief Check if the element before the last one is not null
         * and assign the last element to it 
         */
        if ((&dl)->end->previous)
        {
            (&dl)->end = (&dl)->end->previous;
            delete (&dl)->end->next;
            (&dl)->end->next = NULL;
        }
        else
        {
            /**
             * @brief When the list has only 1 element, just remove it,
             * and set the start and the end to null
             */
            delete (&dl)->end;
            (&dl)->end = (&dl)->start = NULL;
        }

        return true;
    }
}
bool isEmpty(DList dl)
{
    /**
     * @brief Check if the first element is null
     */
    if (!(&dl)->start)
        return true;
    else
        return false;
}