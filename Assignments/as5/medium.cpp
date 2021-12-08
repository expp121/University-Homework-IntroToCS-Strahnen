#include "medium.h"

Medium::Medium() : uniqueAbbreviation(""), author(""), title(""), yearOfPublication(0)
{
}
Medium::Medium(const std::string abbreviation, const std::string author, const std::string title, const unsigned int yearOfPublication) : uniqueAbbreviation{abbreviation}, author{author}, title{title}, yearOfPublication{yearOfPublication}
{
}
Medium::~Medium()
{
}

void Medium::setAuthor(std::string author) { this->author = author; }
void Medium::setTitle(std::string title) { this->title = title; }
void Medium::setUniqueAbbreviation(std::string abbreviation) { this->uniqueAbbreviation = abbreviation; }
void Medium::setYearOfPublication(unsigned int year) { this->yearOfPublication = year; }

std::string Medium::getAuthor() { return this->author; }
std::string Medium::getTitle() { return this->title; }
std::string Medium::getUniqueAbbreviation() { return this->uniqueAbbreviation; }
unsigned int Medium::getPublicationYear() const { return this->yearOfPublication; }

std::string Medium::toString() const
{
    return ('[' + this->uniqueAbbreviation + "] " + this->author + ": " + this->title);
}
