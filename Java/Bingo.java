/**
 * File Name:   Final Project Bingo
 * Description: Creates methods and constuctor for Bingo
 * @author      Tyler Jackimowicz & Manny Moreno
 * @version     19 April 2015
 */
import java.util.*;

public class Bingo
{
    // instance variables
    private int[][] bingoCard = new int[5][5];
    private int numDrawn;

    /**
     * Constructor for objects of class Bingo
     */
    public Bingo()
    {
        
    }
    
    /**
    * Function name: drawCard()
    * Description:   prints out Bingo card layout and randomized numbers
    * @parameters:   None
    * @return:       None
    */
    public void drawCard()
    {
        System.out.println("  | B    I    N    G    O  |");
        System.out.println("--|-------------------------");
        
        for (int i = 0; i < 5; i++)
        {
            System.out.print("  | ");
            for(int j = 0; j < 5; j++)
             {
                    if (i == 2 && j == 2)
                        bingoCard[2][2] = 0;
                    if (bingoCard[i][j] > 9)
                        System.out.print(bingoCard[i][j] + " | ");
                    else
                        System.out.print(bingoCard[i][j] + "  | ");
             }//end for
            System.out.println(" ");
        }//end for
    }//end drawCard()
    
    /**
    * Function name: compareRand(int, int)
    * Description:   compares the random number with other numbers in the column
    *                to make sure there are no repeats
    * @parameters:   int randNum, int column
    * @return:       bool
    */
    public boolean compareRand(int randNum, int column)
    {
        boolean randComp = false;
        for (int i = 0; i < 5; i++)
        {
            if(randNum == bingoCard[i][column])
            randComp = true;
        }//end for
        return randComp;
    }//end compareRand(int,int)
    
    /**
    * Function name: makeCard()
    * Description:   Uses random numbers and fills the array according
    *                to bingo rules
    * @parameters:   None
    * @return:       None
    */
    public void makeCard()
    {
        int randNum, randNum2, randNum3, randNum4, randNum5;
        Random rand = new Random();  
        
        for (int i = 0; i < 5; i ++)
        {
            randNum = rand.nextInt(15) + 1;
            if(compareRand(randNum, 0) != true)
                bingoCard[i][0] = randNum;
            else
                randNum = rand.nextInt(15) + 1;
            bingoCard[i][0] = randNum;
    
            randNum2 = rand.nextInt((30-15) + 1) + 15;
            if(compareRand(randNum2, 1) != true)
                bingoCard[i][1] = randNum2;
            else
                randNum2 = rand.nextInt((30-15) + 1) + 15;
            bingoCard[i][1] = randNum2;
    
            randNum3 = rand.nextInt((45-30) + 1) + 30;
            if(compareRand(randNum3, 2) != true)
                    bingoCard[i][2] = randNum3;
            else
                randNum3 = rand.nextInt((45-30) + 1) + 30;
            bingoCard[i][2] = randNum3;
    
            randNum4 = rand.nextInt((60-45) + 1) + 45;
            if(compareRand(randNum4, 3) != true)
                bingoCard[i][3] = randNum4;
            else
                randNum4 = rand.nextInt((60-45) + 1) + 45;
            bingoCard[i][3] = randNum4;
    
            randNum5 = rand.nextInt((75-60) + 1) + 60;
            if(compareRand(randNum5, 4) != true)
                bingoCard[i][4] = randNum5;
            else
                randNum3 = rand.nextInt((75-60) + 1) + 60;
            bingoCard[i][4] = randNum5;
        }//end for
    }//end makeCard()
    
    /**
    * Function name: drawNum()
    * Description:   Draws a random number and if it fits a category it
    *                prints the letter that corresponds with it
    * @parameters:   None
    * @return:       int
    */
    public int drawNum()
    {
        Random rand = new Random(); 
        int randomNum = rand.nextInt(75) + 1;
        if (randomNum < 16)
            System.out.println("B " + randomNum);
        if (randomNum >= 16 && randomNum < 31)
            System.out.println("I " + randomNum);
        if (randomNum >= 31 && randomNum < 46)
            System.out.println("N " + randomNum);
        if (randomNum >= 46 && randomNum < 61)
            System.out.println("G " + randomNum);
        if (randomNum >= 61)
            System.out.println("O " + randomNum);
        return randomNum;
    }//end drawNum
    
    /**
    * Function name: compareNum(int)
    * Description:   Checks if the number is equal to any number in
    *                the array
    * @parameters:   int num
    * @return:       boolean
    */
    public boolean compareNum(int num)
    {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (num == bingoCard[i][j])
                {
                    bingoCard[i][j] = 0;
                    return true;
                }//end if
        return false;
    }//end compareNum(int)
    
    /**
    * Function name: checkBingo()
    * Description:   checks for a spot in the array that is 0 then
    *                compares the surrounding locations in the array
    *                for more 0s. If there are 5 in a row, Bingo!
    * @parameters:   None
    * @return:       None
    */
    public void checkBingo()
    {
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
                    System.out.println("BINGO!!!");
                    String input;
                    Scanner in = new Scanner(System.in);
                    System.out.println("Would you like to play again? Y/N");
                    input = in.next();
                    
                    
                    if (input.equals("Y") || input.equals("y")){
                        System.out.println("");
                        playBingo();
                    }
                    else
                        System.exit(0);
                }//end if
            }//end for
        }//end for
    }//end checkBingo()
    
    /**
    * Function name: playBingo()
    * Description:   Asks for user input to draw a number, and calls
    *                other methods to play bingo
    * @parameters:   None
    * @return:       None
    */
    public void playBingo()
    {
        String input;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Welcome to Bingo on Java!");
        makeCard();
        drawCard();
        
        do{
            System.out.println("Type D to draw a number, or X to quit game");
            input = in.next();
            
    
            if(input.equals("d") || input.equals("D"))
            {
                numDrawn = drawNum();
                compareNum(numDrawn);
                //testCheck(1);
                checkBingo();
                drawCard();
            }//end if
        }//end do
        while(!input.equals("x") && !input.equals("X"));
        if(input.equals("x") || input.equals("X"))
        {
            System.out.println("Thank you for playing.");
            System.exit(0);
        }//end if
    }//end playBingo()
}//end Bingo class
