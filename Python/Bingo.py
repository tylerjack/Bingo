__author__ = 'Tyler Jackimowicz & Manny Moreno'

#final project Bingo creates the game Bingo and allows the user to play through until they get Bingo.

import random #imports random class

#variables
numDrawn = 0
Matrix = [[0 for x in range((5))]for x in range(5)]

#fill_Array() fills the 2D array with random variables with their specific spots.
def fill_Array():
    i = 0
    #lists for each column
    list1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
    list2 = [16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]

    list3 = [31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45]
    list4 = [46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60]
    list5 = [61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75]
    #shuffles lists to make it randomized
    random.shuffle(list1)
    random.shuffle(list2)
    random.shuffle(list3)
    random.shuffle(list4)
    random.shuffle(list5)
    #stores random number in the array
    while i < 5:
        Matrix[i][0] = list1[i]
        Matrix[i][1] = list2[i]
        Matrix[i][2] = list3[i]
        Matrix[i][3] = list4[i]
        Matrix[i][4] = list5[i]
        i += 1
    Matrix[2][2] = 0

#print_Array() prints out the Bingo card and the numbers from the array.
def print_Array():
    print "  |  B     I     N     G     O  |"
    print "--|-----------------------------|"
    #prints array values with spaces and lines
    for j in range(5):
        print "  | ",
        for i in range(5):
            if Matrix[j][i] > 9:
                print "%s | " % Matrix[j][i],
            else:
                print "%s  | " % Matrix[j][i],
        print " "

#Draws a random number and if it fits a category it prints the letter that corresponds with it
def drawNum():
    i = 1
    listDraw = [] #creates a list to hold values 1 - 75 inclusive and uses this to choose from when drawing numbers.
    while i < 76:
        listDraw.append(i)
        i += 1
    random.shuffle(listDraw)
    numDrawn = listDraw[1]

    if numDrawn < 16:
        print "B %s" % numDrawn
    if numDrawn >= 16 and numDrawn < 31:
        print "I %s" % numDrawn
    if numDrawn >= 31 and numDrawn < 46:
        print "N %s" % numDrawn
    if numDrawn >= 46 and numDrawn < 61:
        print "G %s" % numDrawn
    if numDrawn >= 61:
        print "O %s" % numDrawn
    return numDrawn

#Checks if the number is equal to any number in the array
def compareNum(number):

    for j in range(5):
        for i in range(5):
            if number == Matrix[i][j]:
                Matrix[i][j] = 0

# checks for a spot in the array that is 0 then compares the surrounding locations in the array
# for more 0s. If there are 5 in a row, Bingo!
def checkBingo():
    num1 = 0
    num2 = 0
    num3 = 0
    num4 = 0

    for i in range(5):
        for j in range(5):
            num1 = 0
            num2 = 0
            num3 = 0
            num4 = 0
            if Matrix[i][j] == 0:
                num1 += 1
                num2 += 1
                num3 += 1
                num4 += 1

                #look above
                if(i - 1 >= 0):
                    if(Matrix[i-1][j] == 0):
                        num1 += 1
                        #look above 2
                        if(i-2 >= 0):
                            if(Matrix[i-2][j] == 0):
                                num1 += 1
                                #look above 3
                                if(i-3 >= 0):
                                    if(Matrix[i-3][j] == 0):
                                        num1 += 1
                                        #look above 4
                                        if(i-4 >= 0):
                                            if(Matrix[i-4][j] == 0):
                                                num1 += 1

                #look down
                if(i + 1 < 5):
                    if(Matrix[i+1][j] == 0):
                        num1 += 1
                        #look down 2
                        if(i+2 < 5):
                            if(Matrix[i+2][j] == 0):
                                num1 += 1
                                #look down 3
                                if(i+3 < 5):
                                    if(Matrix[i+3][j] == 0):
                                        num1 += 1
                                        #look down 4
                                        if(i+4 < 5):
                                            if(Matrix[i+4][j] == 0):
                                                num1 += 1

                #look right
                if(j + 1 < 5):
                    if(Matrix[i][j+1] == 0):
                        num2 += 1
                        #look right 2
                        if(j+2 < 5):
                            if(Matrix[i][j+2] == 0):
                                num2 += 1
                                #look right 3
                                if(j+3 < 5):
                                    if(Matrix[i][j+3] == 0):
                                        num2 += 1
                                        #look right 4
                                        if(j+4 < 5):
                                            if(Matrix[i][j+4] == 0):
                                                num2 += 1

                #look left
                if(j - 1 >= 0):
                    if(Matrix[i][j-1] == 0):
                        num2 += 1
                        #look left 2
                        if(j - 2 >= 0):
                            if(Matrix[i][j-2] == 0):
                                num2 += 1
                                #look left 3
                                if(j - 3 >= 0):
                                    if(Matrix[i][j-3] == 0):
                                        num2 += 1
                                        #look right 4
                                        if(j - 4 >= 0):
                                            if(Matrix[i][j-4] == 0):
                                                num2 += 1

                #look upper-left
                if((i - 1 >= 0) and (j - 1 >= 0)):
                    if(Matrix[i-1][j-1] == 0):
                        num3 += 1
                        #look upper-left 2
                        if((i - 2 >= 0) and (j - 2 >= 0)):
                            if(Matrix[i-2][j-2] == 0):
                                num3 += 1
                                #look upper-left 3
                                if((i - 3 >= 0) and (j - 3 >= 0)):
                                    if(Matrix[i-3][j-3] == 0):
                                        num3 += 1
                                        #look upper-left 4
                                        if((i - 4 >= 0) and (j - 4 >= 0)):
                                            if(Matrix[i-4][j-4] == 0):
                                                num3 += 1

                #look lower-right
                if((i + 1 < 5) and (j + 1 < 5)):
                    if(Matrix[i+1][j+1] == 0):
                        num3 += 1
                        #look lower-right 2
                        if((i + 2 < 5) and (j + 2 < 5)):
                            if(Matrix[i+2][j+2] == 0):
                                num3 += 1
                                #look lower-right 3
                                if((i + 3 < 5) and (j + 3 < 5)):
                                    if(Matrix[i+3][j+3] == 0):
                                        num3 += 1
                                        #look lower-right 4
                                        if((i + 4 < 5) and (j + 4 < 5)):
                                            if(Matrix[i+4][j+4] == 0):
                                                num3 += 1

                #look upper-right
                if((i - 1 >= 0) and (j + 1 < 5)):
                    if(Matrix[i-1][j+1] == 0):
                        num4 += 1
                        #look upper-right 2
                        if((i - 2 >= 0) and (j + 2 < 5)):
                            if(Matrix[i-2][j+2] == 0):
                                num4 += 1
                                #look upper-right 3
                                if((i - 3 >= 0) and (j + 3 < 5)):
                                    if(Matrix[i-3][j+3] == 0):
                                        num4 += 1
                                        #look upper-right 4
                                        if((i - 4 >= 0) and (j + 4 < 5)):
                                            if(Matrix[i-4][j+4] == 0):
                                                num4 += 1

                 #look lower-left
                if((i + 1 < 5) and (j - 1 >= 0)):
                    if(Matrix[i+1][j-1] == 0):
                        num4 += 1
                        #look lower-left 2
                        if((i + 2 < 5) and (j - 2 >= 0)):
                            if(Matrix[i+2][j-2] == 0):
                                num4 += 1
                                #look lower-left 3
                                if((i + 3 < 5) and (j - 3 >= 0)):
                                    if(Matrix[i+3][j-3] == 0):
                                        num4 += 1
                                        #look lower-left 4
                                        if((i + 4 < 5) and (j - 4 >= 0)):
                                            if(Matrix[i+4][j-4] == 0):
                                                num4 += 1

                if (num1 == 5 or num2 == 5 or num3 == 5 or num4 == 5):
                    print_Array()
                    print "BINGO!!"
                    print "Would you like to play again? Y/N"
                    input = raw_input()

                    if input == "Y" or input == "y":
                        print ""
                        playBingo()
                    else:
                        exit()

#Asks for user input to draw a number, and calls other methods to play bingo
def playBingo():
    fill_Array()
    print_Array()
    print "Welcome to Bingo on Python!"
    condition = True
    while condition:
        print "Type D to draw a number, or X to quit game"
        input = raw_input()
        if input == "D" or input == "d":
            numDrawn = drawNum()
            compareNum(numDrawn)
            checkBingo()
            print_Array()
        if input == "X" or input == "x":
            condition = False

#Main function
if __name__ == '__main__':
    playBingo()

