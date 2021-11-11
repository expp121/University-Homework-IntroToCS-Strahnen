/**
 * @file stocks.cpp
 * @author Dimitar Banchev
 * @brief Write and Read csv files
 * @version 0.1
 * @date 2021-11-11
 * 
 * @copyright Copyright (c) 2021
 * 
 */

#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <sstream>

/**
 * @brief Opens a csv file and goes through all elements and returns them as a matrix
 * 
 * @param filename 
 * @return std::vector<std::vector<std::string>> returns a matrix of strings representing every row and column
 */
std::vector<std::vector<std::string>> read_csv(std::string filename)
{

    /**
     * @brief holds the return result
     */
    std::vector<std::vector<std::string>> result;

    /**
     * @brief Opens the file
     * 
     * @return std::ifstream 
     */
    std::ifstream file(filename);

    /**
     * @brief checks if the file is properly openned
     * 
     */
    if (file.good())
    {
        std::string line, element;

        /**
         * @brief holds a row of the file
         */
        std::vector<std::string> splitLine;

        /**
         * @brief Go through each line of the file
         * 
         */
        while (std::getline(file, line))
        {
            /**
             * @brief convert the whole line into a stream for further spliting
             * 
             * @return std::stringstream 
             */
            std::stringstream ss(line);

            /**
             * @brief Split each element of the line
             * 
             */
            while (ss.good())
            {
                /**
                 * @brief Splits by ',' and saves the result into 'element' variable
                 * 
                 */
                std::getline(ss, element, ',');

                if (element[0] == ' ')
                    element.erase(0, 1);

                splitLine.push_back(element);
            }
            result.push_back(splitLine);
            splitLine.clear();
        }

        file.close();
    }
    return result;
}

/**
 * @brief Writes data to a file, each element is separated by a comma
 * 
 * @param filename A file to write to
 * @param data The data which is going to be written in the file
 * @param colName The first row of the file will contain the column names as a comment
 * @return true The function successfully wrote to the file
 * @return false Unable to open the file
 */
bool write_csv(std::string filename, std::vector<std::vector<std::string>> data, std::vector<std::string> colName)
{

    std::ofstream file(filename);
    if (file.is_open())
    {

        /**
         * @brief Write the column names as a first row comment
         * 
         */
        file << "# ";
        for (size_t i = 0; i < colName.size(); i++)
            file << colName[i] + ", ";

        file << '\n';

        /**
         * @brief Write every element to the file, separated by a comma
         * 
         */
        for (size_t row = 0; row < data.size(); row++)
        {
            for (size_t col = 0; col < data[row].size(); col++)
            {
                if (col == data[row].size() - 1)
                    file << data[row][col];
                else
                    file << data[row][col] + ',';
            }
            file << '\n';
        }
        file.close();
        return 0;
    }
    else
    {
        std::cout << "Cannot open file!!";
        return 1;
    }
}


/**
 * @brief Return the sum of all integers in a given column of a matrix
 * 
 * @param matrix String matrix, representing each row and column
 * @param column Which column to Sum
 * @return int The sum of the column
 */
int sumColumnI(std::vector<std::vector<std::string>> matrix, int column)
{
    int result(0);
    for (size_t i = 0; i < matrix.size(); i++)
        result += stoi(matrix[i][column - 1]);

    return result;
}

/**
 * @brief Same as sumColumnI but for integers(Return the sum of all doubles in a given column of a matrix)
 * 
 * @param matrix String matrix, representing each row and column
 * @param column Which column to Sum
 * @return double The sum of the column
 */
double sumColumnD(std::vector<std::vector<std::string>> matrix, int column)
{
    double result(0);
    for (size_t i = 0; i < matrix.size(); i++)
        result += stod(matrix[i][column - 1]);

    return result;
}

int main()
{
    std::vector<std::vector<std::string>> matrix = read_csv("testFile.test");
    write_csv("test.out", matrix, {"No", "Description", "Actual Stock", "Maximum Stock", "Cost Price", "Consumption per Day", "Order Duration"});

    /*
    The reorder point is calculated from the consumption per day and the order duration, 
    whereby an additional 2 days reserve is calculated. 
    An order proposal has to be generated if the actual stock is less than or equal to the reorder point. 
    The order proposal is then calculated from the difference between the actual stock and the reorder point.
    */
    //VERY VAGUE EXPLANATION, DIDN'T UNDERSTAND WHAT TO DO!!
    return 0;
}
