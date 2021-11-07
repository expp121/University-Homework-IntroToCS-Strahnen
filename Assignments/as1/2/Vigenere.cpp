/**
 * Author: expp
 * Programm which either decrypts or encrypts a message with Vigenere's Algorithm
 * It takes a text and equally is sized password
 */
#include <iostream>
#include <string>
#include <limits>
#include <algorithm>

/** 
 * @Brief Encrypts or Decrypts a given text.
 * @param string text, The text which will be either encrypted or decrypted.
 * @param string pass, The password with which the text will be en/decrypted.
 * @param bool encrypt, Instructs whether to encrypt or decrypt.
 * @return string.
 */
std::string enc_dec_rypt(std::string text, std::string const &pass, bool const &encrypt)
{
    std::string result = "";

    //!Check if the string is not empty, and also if the password is longer or equal to the lenght of the text
    //!because it needs to be at least the lenght of the text
    if (text.length() > 0 && pass.length() >= text.length())
    {
        int tmp(0);

        if (encrypt)
            //!toUpper the whole string, done for easier encryption(Check ASCII for more info.)
            std::transform(text.begin(), text.end(), text.begin(), ::toupper);

        //!Loop through every chracter of the string
        for (size_t i = 0; i < text.length(); i++)
            if (text[i] != ' ' || pass[i] != ' ')
            {
                //!Find how much to offset the base letter 'A' to the right(Formula found on the internet)
                tmp = (text[i] + (encrypt ? pass[i] : -pass[i])) % 26;

                //!This code is here, because for some reason computers don't like when the number
                //!before the modulo is negative, resulting in wrong calculation, so that fixes it
                if (tmp < 0)
                    tmp += 26;

                //!convert the result into ASCII Letters
                result += (char)(65 + tmp);
            }
            else
                result += ' ';

        if (!encrypt)
            //!toLower, when decrypting(not needed)
            std::transform(result.begin(), result.end(), result.begin(), ::tolower);
    }

    return result;
}
int main()
{
    //!Get user input
    char choice{};
    std::string text{}, password{};
    std::cout << "Do you want to decrypt or encrypt?\n1. Encrypt     2. Decrypt\n";

    do
    {
        std::cout << "$ ";
        std::cin >> choice;
    } while (choice != '1' && choice != '2');

    //!This piece of code makes 'cin' ignore '\n', because they were buffered and were messing with the
    //!next input lines
    //std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "Enter the text to be " << ((!choice) ? "encrypted " : "decrypted") << ":\n$ ";
    std::getline(std::cin >> std::ws, text); // std::ws ignores white spaces and '\n' characters from previous input

    std::cout << "Enter a password to " << ((!choice) ? "encrypt " : "decrypt") << " with:\n$ ";
    std::getline(std::cin >> std::ws, password);

    //!Convert the (char)'1' or (char)'2' to (int/bool)0 or (int/bool)1
    choice -= 49;

    std::cout << "Your " << ((!choice) ? "encrypted " : "decrypted") << " message is: " << enc_dec_rypt(text, password, !choice) << "\n";
    return 0;
}
