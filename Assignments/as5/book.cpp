#include "book.h"

Book::Book() : Medium(), publisher("")
{
}

Book::Book(const std::string abbreviation, const std::string author,
           const std::string title, const unsigned int yearOfPublication,
           std::string publisher) : Medium(abbreviation, author, title, yearOfPublication), publisher{publisher}
{
}

Book::~Book() {}

void Book::setPublisher(std::string publisher) { this->publisher = publisher; }
std::string Book::getPublisher() { return this->publisher; }
std::string Book::toString() const
{
    return (Medium::toString() + '\n' + this->publisher + ',' + std::to_string(Medium::getPublicationYear()));
}
