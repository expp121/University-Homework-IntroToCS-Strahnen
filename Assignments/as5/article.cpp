#include "article.h"

Article::Article() : Medium(), magazineName(""), magazineNumber(0), pageNumber(0)
{
}
Article::Article(const std::string abbreviation, const std::string author,
                 const std::string title, const unsigned int yearOfPublication,
                 const std::string magazineName, const unsigned int magazineNumber,
                 const unsigned int pageNumber) : Medium(abbreviation, author, title, yearOfPublication),
                                                  magazineName{magazineName}, magazineNumber{magazineNumber}, pageNumber{pageNumber}
{
}
Article::~Article() {}
void Article::setMagazineName(std::string magazineName) { this->magazineName = magazineName; }
void Article::setMagazineNumber(unsigned int magazineNumber) { this->magazineNumber = magazineNumber; }
void Article::setPageNumber(unsigned int pageNumber) { this->pageNumber = pageNumber; }

std::string Article::getMagazineName() { return this->magazineName; }
unsigned int Article::getMagazineNumber() { return this->magazineNumber; }
unsigned int Article::getPageNumber() { return this->pageNumber; }
std::string Article::toString() const
{
    /**
     * @brief Return a string form of the object in this format:
     * ['abbriv'] 'Author': 'Title'
     * 'MagazineName','MagazineNumber','YearOfPublication','PageNumbe'
     * 
     */
    return (Medium::toString() + '\n' +
            this->magazineName + ',' + std::to_string(this->magazineNumber) + ',' +
            std::to_string(Medium::getPublicationYear()) + ',' +
            std::to_string(this->pageNumber));
}
