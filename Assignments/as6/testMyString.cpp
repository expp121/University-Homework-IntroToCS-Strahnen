// //#include "mystring.h"
// #pragma GCC diagnostic push
// #pragma GCC diagnostic ignored "-Weffc++"
// #pragma GCC diagnostic ignored "-Wsign-conversion"
// #pragma GCC diagnostic ignored "-Weffc++"
// #include <boost/test/unit_test.hpp>
// #pragma GCC diagnostic pop
// //#define BOOST_TEST_MODULE stringexercise::mystring test

// int main(){

// }

#define BOOST_TEST_MODULE mystring test
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Weffc++"
#pragma GCC diagnostic ignored "-Wsign-conversion"
#pragma GCC diagnostic ignored "-Weffc++"
#include <boost/test/included/unit_test.hpp>
#pragma GCC diagnostic pop
#include "mystring.h"
using namespace stringexercise;

std::string a("asdas");
mystring *empt = new mystring();
mystring chararr2("asds");
mystring chararr(a);
mystring cpconstr(chararr);

BOOST_AUTO_TEST_CASE(constructors_test)
{
    BOOST_CHECK_MESSAGE(empt->is_empty() == true, "empt->is_empty() result: " << empt->is_empty());
    BOOST_CHECK_MESSAGE(empt->length() == 0, "empt->length() result: " << empt->length());
    BOOST_CHECK_MESSAGE(std::strcmp(empt->c_str(), "") == 0, "srtcmp(empt->c_str(), \"\" result: " << std::strcmp(empt->c_str(), ""));
    BOOST_CHECK_MESSAGE(chararr2.is_empty() == false, "chararr2.is_empty() result: " << chararr2.is_empty());
    BOOST_CHECK_MESSAGE(chararr2.length() == 4, "chararr2.length() result: " << chararr2.length());
    BOOST_CHECK_MESSAGE(std::strcmp(chararr2.c_str(), "asds") == 0, "srtcmp(chararr2.c_str(), \"\" result: " << std::strcmp(chararr2.c_str(), ""));
    BOOST_CHECK_MESSAGE(chararr.is_empty() == false, "chararr.is_empty() result: " << chararr.is_empty());
    BOOST_CHECK_MESSAGE(chararr.length() == 5, "chararr.length() result: " << chararr.length());
    BOOST_CHECK_MESSAGE(std::strcmp(chararr.c_str(), "asdas") == 0, "srtcmp(chararr.c_str(), \"\" result: " << std::strcmp(chararr.c_str(), ""));
    BOOST_CHECK_MESSAGE(cpconstr.is_empty() == false, "cpconstr.is_empty() result: " << cpconstr.is_empty());
    BOOST_CHECK_MESSAGE(cpconstr.length() == 5, "cpconstr.length() result: " << cpconstr.length());
    BOOST_CHECK_MESSAGE(std::strcmp(cpconstr.c_str(), "asdas") == 0, "srtcmp(cpconstr.c_str(), \"\" result: " << std::strcmp(cpconstr.c_str(), ""));
}

BOOST_AUTO_TEST_CASE(operators_test)
{
    BOOST_CHECK_MESSAGE(std::strcmp((chararr += chararr2).c_str(), "asdasasds") == 0, "chararr(asdas) += chararr2(asds) result: " << chararr.c_str());
    BOOST_CHECK_MESSAGE(std::strcmp((cpconstr += 'a').c_str(), "asdasa") == 0, "cpconstr(asdas) += 'a' result: " << cpconstr.c_str());
    BOOST_CHECK_MESSAGE(std::strcmp((chararr2 += "beibi").c_str(), "asdsbeibi") == 0, "chararr2(asds) += \"beibi\" result: " << chararr2.c_str());
    BOOST_CHECK_MESSAGE(std::strcmp((chararr2 = cpconstr).c_str(), "asdasa") == 0, "chararr2 = cpconstr(asdasa) result: " << chararr2.c_str());
    chararr2.swap(chararr);
    BOOST_CHECK_MESSAGE(chararr2 != chararr, "");
    std::cout << chararr2 << '\n';
    std::cin >> chararr;
}
BOOST_AUTO_TEST_CASE(comparsion_operators_test)
{
    char c = chararr2[0];
    char ca = a[0];
    BOOST_CHECK_MESSAGE(c == ca, "chararr2(" << chararr2.c_str() << ")[0] == a(" << a << ")[0] result: " << (c == ca));
    BOOST_CHECK_MESSAGE((chararr2 == cpconstr) == true, "chararr2(" << chararr2.c_str() << ") == cpconstr(" << cpconstr << ") result: " << (cpconstr == chararr2));
    BOOST_CHECK_MESSAGE((chararr2 != cpconstr) == false, "chararr2(" << chararr2.c_str() << ") != cpconstr(" << cpconstr << ") result: " << (cpconstr != chararr2));
    BOOST_CHECK_MESSAGE((chararr2 > cpconstr) == false, "chararr2(" << chararr2.c_str() << ") > cpconstr(" << cpconstr << ") result: " << (cpconstr > chararr2));
    BOOST_CHECK_MESSAGE((chararr2 < cpconstr) == false, "chararr2(" << chararr2.c_str() << ") < cpconstr(" << cpconstr << ") result: " << (cpconstr < chararr2));
    BOOST_CHECK_MESSAGE((chararr2 >= cpconstr) == true, "chararr2(" << chararr2.c_str() << ") >= cpconstr(" << cpconstr << ") result: " << (cpconstr >= chararr2));
    BOOST_CHECK_MESSAGE((chararr2 <= cpconstr) == true, "chararr2(" << chararr2.c_str() << ") <= cpconstr(" << cpconstr << ") result: " << (cpconstr <= chararr2));
}
BOOST_AUTO_TEST_CASE(plus_operator_test)
{
    chararr2 + "dasd";

    BOOST_CHECK_MESSAGE(std::strcmp((chararr2 + cpconstr).c_str(), "asdasaasdasa") == 0, "chararr2(" << chararr2.c_str() << ") + cpconstr(" << cpconstr.c_str() << ") result: " << chararr2 + cpconstr);
    BOOST_CHECK_MESSAGE(std::strcmp((chararr2 + "buba").c_str(), "asdasabuba") == 0, "chararr2(" << chararr2.c_str() << ") + \"buba\" result: " << chararr2 + "buba");
    BOOST_CHECK_MESSAGE(std::strcmp(("buba" + chararr2).c_str(), "bubaasdasa") == 0, "\"buba\" + chararr2(" << chararr2.c_str() << ") result: "
                                                                                                            << "buba" + chararr2);
}