/*
* File Name: Final project Bingo.cpp
* Purpose:   Makes functions and constructor for main class
* Name:      Tyler Jackimowicz
* Date:      19 April 2015
*/

#include "Bingo.h"
#include <iostream>
#include <cstdlib>

using namespace std;

/*
* Function name: default constructor
* Description:   Creates Bingo object
* @parameters:   None
* @return:       None
*/
Bingo::Bingo()
{
}//end default constructor

/*
* Function name: de-constructor
* Description:   Removes object
* @parameters:   None
* @return:       None
*/
Bingo::~Bingo()
{
}//end Bingo de-constructor

/*
* Function name: drawCard()
* Description:   prints out Bingo card layout and randomized numbers
* @parameters:   None
* @return:       None
*/
void Bingo::drawCard()
{
	cout << "  | B    I    N    G    O  |" << endl;
	cout << "--|-------------------------" << endl;

	for (int i = 0; i < 5; i++)
	{
        cout << "  | ";
        for(int j = 0; j < 5; j++)
             {
                    if (i == 2 && j == 2)
                        bingoCard[2][2] = 0;
                    if (bingoCard[i][j] > 9)
                        cout << bingoCard[i][j] << " | ";
                    else
                        cout << bingoCard[i][j] << "  | ";
             }//end for
             cout << endl;
    }//end for
}//end drawCard()

/*
* Function name: compareRand(int, int)
* Description:   compares the random number with other numbers in the column
*                to make sure there are no repeats
* @parameters:   int randNum, int column
* @return:       bool
*/
bool Bingo::compareRand(int randNum, int column)
{
    bool randComp = false;
    for (int i = 0; i < 5; i++)
    {
        if(randNum == bingoCard[i][column])
            randComp = true;
    }//end for
    return randComp;
}//end compareRand(int,int)

/*
* Function name: makeCard()
* Description:   Uses random numbers and fills the array according
*                to bingo rules
* @parameters:   None
* @return:       None
*/
void Bingo::makeCard()
{
    int randNum, randNum2, randNum3, randNum4, randNum5;
    srand(time(NULL));
    for (int i = 0; i < 5; i ++)
    {
        randNum = rand() % 15 + 1;
        if(compareRand(randNum, 0) != true)
            bingoCard[i][0] = randNum;
        else
            randNum = rand() % 15 + 1;
        bingoCard[i][0] = randNum;

        randNum2 = rand() % 15+15;
        if(compareRand(randNum2, 1) != true)
            bingoCard[i][1] = randNum2;
        else
            randNum2 = rand() % 15 + 15;
        bingoCard[i][1] = randNum2;

        randNum3 = rand() % 15 + 30;
        if(compareRand(randNum3, 2) != true)
                bingoCard[i][2] = randNum3;
        else
            randNum3 = rand() % 15 + 30;
        bingoCard[i][2] = randNum3;

        randNum4 = rand() % 15 + 45;
        if(compareRand(randNum4, 3) != true)
            bingoCard[i][3] = randNum4;
        else
            randNum4 = rand() % 15 + 45;
        bingoCard[i][3] = randNum4;

        randNum5 = rand() % 15 + 60;
        if(compareRand(randNum5, 4) != true)
            bingoCard[i][4] = randNum5;
        else
            randNum3 = rand() % 15 + 60;
        bingoCard[i][4] = randNum5;
    }//end for
}//end makeCard()

/*
* Function name: drawNum()
* Description:   Draws a random number and if it fits a category it
*                prints the letter that corresponds with it
* @parameters:   None
* @return:       int
*/
int Bingo::drawNum()
{
    int randomNum = rand() % 75 + 1;
    if (randomNum < 16)
        cout << "B " << randomNum << endl;
    if (randomNum >= 16 && randomNum < 31)
        cout << "I " << randomNum << endl;
    if (randomNum >= 31 && randomNum < 46)
        cout << "N " << randomNum << endl;
    if (randomNum >= 46 && randomNum < 61)
        cout << "G " << randomNum << endl;
    if (randomNum >= 61)
        cout << "O " << randomNum << endl;
    return randomNum;
}//end drawNum()

/*
* Function name: compareNum(int)
* Description:   Checks if the number is equal to any number in
*                the array
* @parameters:   int num
* @return:       bool
*/
bool Bingo::compareNum(int num)
{
    for (int i = 0; i < 5; i++)
        for (int j = 0; j < 5; j++)
            if (num == bingoCard[i][j])
            {
                bingoCard[i][j] = 0;
                return true;
            }//end if
}//end compareNum(int)

/*
* Function name: checkBingo()
* Description:   checks for a spot in the array that is 0 then
*                compares the surrounding locations in the array
*                for more 0s. If there are 5 in a row, Bingo!
* @parameters:   None
* @return:       None
*/
void Bingo::checkBingo()
{
    //variables
    int numCount1;
    int numCount2;
    int numCount3;
    int numCount4;
    
    for(int i = 0; i < 5; i++)
    {
        for(int j = 0; j < 5; j++)
        {
            numCount1 = 0;
            numCount2 = 0;
            numCount3 = 0;
            numCount4 = 0;
            if (bingoCard[i][j] == 0)
            {
                numCount1++;
                numCount2++;
                numCount3++;
                numCount4++;
            
                //look above
                if(i - 1 >= 0)
                if(bingoCard[i-1][j] == 0)
                {
                    numCount1++;
                    //look above 2
                    if(i-2 >= 0)
                    if(bingoCard[i-2][j] == 0)
                    {
                        numCount1++;
                        //look above 3
                        if(i-3 >= 0)
                        if(bingoCard[i-3][j] == 0)
                        {
                            numCount1++;
                            //look above 4
                            if(i-4 >= 0)
                            if(bingoCard[i-4][j] == 0)
                                numCount1++;}}}

                //look down
                if(i + 1 < 5)
                if(bingoCard[i+1][j] == 0)
                {
                    numCount1++;
                    //look down 2
                    if(i+2 < 5)
                    if(bingoCard[i+2][j] == 0)
                    {
                        numCount1++;
                        //look down 3
                        if(i+3 < 5)
                        if(bingoCard[i+3][j] == 0)
                        {
                            numCount1++;
                            //look down 4
                            if(i+4 < 5)
                            if(bingoCard[i+4][j] == 0)
                                numCount1++;}}}

                //look left
                if(j - 1 >= 0)
                if(bingoCard[i][j-1] == 0)
                {
                    numCount2++;
                    //look left 2
                    if(j-2 >= 0)
                    if(bingoCard[i][j-2] == 0)
                    {
                        numCount2++;
                        //look left 3
                        if(j-3 >= 0)
                        if(bingoCard[i][j-3] == 0)
                        {
                            numCount2++;
                            //look left 4
                            if(j-4 >= 0)
                            if(bingoCard[i][j-4] == 0)
                                numCount2++;}}}

                //look right
                if(j + 1 < 5)
                if(bingoCard[i][j+1] == 0)
                {
                    numCount2++;
                    //look right 2
                    if(j+2 < 5)
                    if(bingoCard[i][j+2] == 0)
                    {
                        numCount2++;
                        //look right 3
                        if(j+3 < 5)
                        if(bingoCard[i][j+3] == 0)
                        {
                            numCount2++;
                            //look right 4
                            if(j+4 < 5)
                            if(bingoCard[i][j+4] == 0)
                                numCount2++;}}}


                // look at upper-left
                if ((i - 1 >= 0) && (j - 1 >= 0))
                if (bingoCard[(i - 1)][(j - 1)] == 0)
                {
                    numCount3++;
                    // look at upper-left 2
                    if ((i - 2 >= 0) && (j - 2 >= 0))
                    if (bingoCard[(i - 2)][(j - 2)] == 0)
                    {
                        numCount3++;
                        // look at upper-left 3
                        if ((i - 3 >= 0) && (j - 3 >= 0))
                        if (bingoCard[(i - 3)][(j - 3)] == 0)
                        {
                            numCount3++;
                            // look at upper-left 4
                            if ((i - 4 >= 0) && (j - 4 >= 0))
                            if (bingoCard[(i - 4)][(j - 4)] == 0)
                                numCount3++;}}}

                // look at lower-Right
                if ((i + 1 < 5) && (j + 1 < 5))
                if (bingoCard[i + 1][j + 1] == 0)
                {
                    numCount3++;
                    // look at lower-Right 2
                    if ((i + 2 < 5) && (j + 2 < 5))
                    if (bingoCard[i + 2][j + 2] == 0)
                    {
                        numCount3++;
                        // look at lower-Right 3
                        if ((i + 3 < 5) && (j + 3 < 5))
                        if (bingoCard[i + 3][j + 3] == 0)
                        {
                            numCount3++;
                            // look at lower-Right 4
                            if ((i + 4 < 5) && (j + 4 < 5))
                            if (bingoCard[i + 4][j + 4] == 0)
                                numCount3++;}}}

                // look at upper-right
                if ((i - 1 >= 0) && (j + 1 < 5))
                if (bingoCard[(i - 1)][(j + 1)] == 0)
                {
                    numCount4++;
                    // look at upper-right 2
                    if ((i - 2 >= 0) && (j + 2 < 5))
                    if (bingoCard[(i - 2)][(j + 2)] == 0)
                    {
                        numCount4++;
                        // look at upper-right 3
                        if ((i - 3 >= 0) && (j + 3 < 5))
                        if (bingoCard[(i - 3)][(j + 3)] == 0)
                        {
                            numCount4++;
                            // look at upper-right 4
                            if ((i - 4 >= 0) && (j + 4 < 5))
                            if (bingoCard[(i - 4)][(j + 4)] == 0)
                                numCount4++;}}}

                // look at lower-Left
                if ((i + 1 < 5) && (j - 1 >= 0))
                if (bingoCard[(i + 1)][(j - 1)] == 0)
                {
                    numCount4++;
                    // look at lower-Left 2
                    if ((i + 2 < 5) && (j - 2 >= 0))
                    if (bingoCard[(i + 2)][(j - 2)] == 0)
                    {
                        numCount4++;
                        // look at lower-Left 3
                        if ((i + 3 < 5) && (j - 3 >= 0))
                        if (bingoCard[(i + 3)][(j - 3)] == 0)
                        {
                            numCount4++;
                            // look at lower-Left 4
                            if ((i + 4 < 5) && (j - 4 >= 0))
                            if (bingoCard[(i + 4)][(j - 4)] == 0)
                                numCount4++;}}}
            }//end if
            
            if (numCount1 == 5 || numCount2 == 5 || numCount3 == 5 || numCount4 == 5)
            {
                drawCard();
                cout << "BINGO!!!" << endl;
                char input;
                cout << "Would you like to play again? Y/N" << endl;
                cin >> input;
                if (input == 'Y' || input == 'y'){
                    cout << endl;
                    playBingo();
                }
                else
                    exit(1);
            }//end if
        }//end for
    }//end for
}//end checkBingo()

/*
* Function name: playBingo()
* Description:   Asks for user input to draw a number, and calls
*                other methods to play bingo
* @parameters:   None
* @return:       None
*/
void Bingo::playBingo()
{
    char input;

    cout << "Welcome to Bingo on C++!" << endl;
    makeCard();
    drawCard();
    
    do{
        cout << "Type D to draw a number, or X to quit game" << endl;
        cin >> input;
        cout << endl;

        if(input == 'd' || input == 'D')
        {
            numDrawn = drawNum();
            compareNum(numDrawn);
            checkBingo();
            drawCard();
        }//end if
    }//end do
    while(input != 'x' && input != 'X');
    if(input == 'x' || input == 'X')
    {
        cout << "Thank you for playing." << endl;
        system("PAUSE");
        exit(1);
    }//end if
}//end playBingo()
