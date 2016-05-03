/*
* File Name: Final Project Main()
* Purpose:   To create Bingo game and use functions from other class.
* Name:      Tyler Jackimowicz
* Date:      19 April 2015
*/

#include "Bingo.h"
#include <cstdlib>
#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    Bingo newCard; // creates new bingo card object
    newCard.playBingo(); // calls playBingo function
    system("PAUSE");
    return EXIT_SUCCESS;
}//end main()
