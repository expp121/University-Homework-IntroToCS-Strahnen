#include "mystring.h"
#include <cstring>

stringexercise::mystring::mystring() : occupied(0), capacity(0), sequence(new char('\0'))
{
}
stringexercise::mystring::mystring(const char str[]) : occupied(std::strlen(str)), capacity(std::strlen(str)), sequence(new char[this->capacity])
{
    std::strcpy(this->sequence, str);
}
stringexercise::mystring::mystring(const std::string str) : occupied(std::strlen(str.c_str())), capacity(std::strlen(str.c_str())), sequence(strdup(str.c_str())) {}
stringexercise::mystring::mystring(const stringexercise::mystring &source) : occupied(source.occupied), capacity(source.capacity), sequence(new char[capacity])
{
    std::strcpy(this->sequence, source.sequence);
}
stringexercise::mystring::~mystring()
{
    delete[] this->sequence;
}

// modifying member functions
stringexercise::mystring &stringexercise::mystring::operator+=(const stringexercise::mystring &addend)
{
    this->occupied += addend.occupied;
    if (this->occupied >= this->capacity)
    {
        this->capacity += addend.capacity;
        char *temp = this->sequence;
        this->sequence = new char[this->capacity];
        std::strcpy(this->sequence, temp);
        delete[] temp;
    }
    std::strcat(this->sequence, addend.sequence);
    return *this;
}
stringexercise::mystring &stringexercise::mystring::operator+=(const char addend[])
{
    this->occupied += std::strlen(addend);
    if (this->occupied >= this->capacity)
    {
        this->capacity += std::strlen(addend);
        char *temp = this->sequence;
        this->sequence = new char[this->capacity];
        std::strcpy(this->sequence, temp);
        delete[] temp;
    }

    std::strcat(this->sequence, addend);
    return *this;
}
stringexercise::mystring &stringexercise::mystring::operator+=(const char addend)
{
    this->occupied++;
    if (this->occupied >= this->capacity)
    {
        this->capacity += 10;
        char *temp = this->sequence;
        this->sequence = new char[this->capacity];
        std::strcpy(this->sequence, temp);
        delete[] temp;
        this->sequence[this->occupied - 1] = addend;
    }
    return *this;
}

stringexercise::mystring &stringexercise::mystring::operator=(const stringexercise::mystring &source)
{
    this->capacity = source.capacity;
    this->occupied = source.occupied;
    std::strcpy(this->sequence, source.sequence);
    return *this;
}
const char &stringexercise::mystring::operator[](size_t position) const
{
    if (position > this->occupied)
        throw("Index out of bounds");

    return (this->sequence[position]);

} // char at a distinct position
char &stringexercise::mystring::operator[](size_t position)
{
    if (position > this->occupied)
        throw("Index out of bounds");

    return (this->sequence[position]);
} // char at a distinct position

void stringexercise::mystring::swap(mystring &str)
{
    mystring temp = str;
    str = *this;
    *this = temp;
    //TODO Maybe delete the old pointer(memory leak)
} // exchange of two strings
std::ostream &stringexercise::operator<<(std::ostream &outs, const mystring &source)
{
    ///TODO TEST IT
    outs << source.sequence;
    return outs;
}
bool stringexercise::operator==(const mystring &s1, const mystring &s2)
{
    if (s1.occupied != s2.occupied)
        return false;
    for (size_t i = 0; i < s1.occupied; i++)
        if (s1.c_str()[i] != s2.c_str()[i])
            return false;
    return true;
}
bool stringexercise::operator!=(const mystring &s1, const mystring &s2)
{
    return !(s1 == s2);
}
bool stringexercise::operator>=(const mystring &s1, const mystring &s2)
{
    int s1l(0), s2l(0);
    size_t s1_length(s1.occupied), s2_length(s2.occupied);
    if (s1_length == s2_length)
    {
        for (size_t i = 0; i < s1_length; i++)
        {
            s1l += s1[i];
            s2l += s2[i];
        }
    }
    else if (s1_length > s2_length)
    {
        for (size_t i = 0; i < s2_length; i++)
        {
            s1l += s1[i];
            s2l += s2[i];
        }
        for (size_t i = 0; i < s1_length - s2_length; i++)
            s1l += s1[s2_length + i];
    }
    else
    {
        for (size_t i = 0; i < s1_length; i++)
        {
            s1l += s1[i];
            s2l += s2[i];
        }
        for (size_t i = 0; i < s2_length - s1_length; i++)
            s2l += s2[s1_length + i];
    }

    return s1l >= s2l;
}
bool stringexercise::operator<=(const mystring &s1, const mystring &s2)
{
    int s1l(0), s2l(0);
    size_t s1_length(s1.occupied), s2_length(s2.occupied);
    if (s1_length == s2_length)
    {
        for (size_t i = 0; i < s1_length; i++)
        {
            s1l += s1[i];
            s2l += s2[i];
        }
    }
    else if (s1_length > s2_length)
    {
        for (size_t i = 0; i < s2_length; i++)
        {
            s1l += s1[i];
            s2l += s2[i];
        }
        for (size_t i = 0; i < s1_length - s2_length; i++)
            s1l += s1[s2_length + i];
    }
    else
    {
        for (size_t i = 0; i < s1_length; i++)
        {
            s1l += s1[i];
            s2l += s2[i];
        }
        for (size_t i = 0; i < s2_length - s1_length; i++)
            s2l += s2[s1_length + i];
    }

    return s1l <= s2l;
}
bool stringexercise::operator>(const mystring &s1, const mystring &s2)
{
    return !(s1 <= s2);
}
bool stringexercise::operator<(const mystring &s1, const mystring &s2)
{
    return !(s1 >= s2);
}

stringexercise::mystring stringexercise::operator+(const mystring &s1, const mystring &s2)
{
    mystring tmp;
    tmp = s1;
    tmp += s2;
    return tmp;
}
stringexercise::mystring stringexercise::operator+(const mystring &s1, const char *s2)
{
    mystring tmp;
    tmp = s1;
    tmp += s2;
    return tmp;
}
stringexercise::mystring stringexercise::operator+(const char *s1, const mystring &s2)
{
    mystring tmp(s1);
    tmp += s2;
    return tmp;
}

std::ostream &operator<<(std::ostream &outs, const stringexercise::mystring &source)
{
    for (size_t i = 0; i < source.length(); i++)
        outs << source.c_str()[i];
    return outs;
}
std::istream &stringexercise::operator>>(std::istream &ins, mystring &target)
{
    char tmp[256];
    ins >> tmp;
    mystring temp(tmp);
    target = temp;
    return ins;
}