CC = g++
FLAGS = -Wall -g

all: myProgram

myProgram: *.o
$(CC) *.o $(FLAGS) -o myProgram


*.o: *.cpp
$(CC) -c *.cpp $(FLAGS) -o *.o

clean: 
del *.o