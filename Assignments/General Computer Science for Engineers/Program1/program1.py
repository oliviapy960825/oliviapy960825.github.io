#Peiyu Wang, Ruxia Qin
import random

'''
Provides a free “Bulls and Cows” game service:
1. Use the function displayWelcomMessage to display the welcome message and general instructions to the user.
2. Use the function playOrNot to ask the player whether he/she wishes to play or exit.
3. If exit is entered, end the game. If not, start a new game.
4. Use the function computerNumber to randomly generate an integer with 4 unique digits. Each digit must be in the range of 1 to 9.
5. Use the function userEnterNumber to ask the user to enter a number he or she guesses. \
Verify the user's guess. If its digits are not unique, gracefully request the user to reenter a valid number.
6. Use the function calculateBullAndCow to calculate and display the bulls and cows the user gets. \
the rule for the game is: Compare the user's number with the computer' number. If the matching digits are in the right positions, they are bulls, \
and if in different positions, they are cows.
7. Continue the game until the correct guess is made or the player wishes to quit.
8. Use the function playTheGame to show the results of the game/ When the correct guess is made, display a congratulatory message. \
If the player exits the game prematurely, then simply display the number and end the game.
9. Ask the player whether he/she wishes to continue or exit.
'''
def main():
    '''
    Display the welcome message and the instructions for the game "bulls and cows", \
    and ask whether the user wants to play the game. If the user wants to exit, show the message of game ends, \
    otherwise, begin the game, and ask the user whether he or she wants to play another game at the end of the game.
    Parameters:
    None
    Variables:
    playOrNot(str) - whether the user wants to play a new game or not
    '''
    displayWelcomeMessage()
    playOrNot = input('Do you want to play a new game or exit? Enter "play" or "exit": ')
    while playOrNot == "play":
        playOrNot = playTheGame()
    print("Game ends.")



def displayWelcomeMessage():
    '''
    Display the wellcome message and show the instructions.
    '''
    print("Welcome to the game!")
    print("Here are the instructions: first the computer generates a number and asks for your input, \
if your guess has one digit on its right position, you have one bull, \
if you get several digits right, but not in right position, you will get as many cows as the right digits. \
Then it will ask you to type in a number again until you get the right one. You can also exit whenever you want.")

def playTheGame():
    '''
    Ask the user whether he or she wants to play the game, and if she or he wants, generate a random secret 4-digit number. \
    Then compare user's number with the random number, and tell the user how much bulls and cows he or she gets. \
    If the user gets the right number, congradulate him or her.
    Parameters:
    None
    Variables:
    computerNumber(int) - a randomly generated number with four unique digits
    userNumber(int) - the number user guesses or the information of exit
    bull(int) - the number of exact right digits the user gets, and exact means the right number and the right position
    playOrNot(str) - whether the user wants to play a new game or not
    Return:
    playOrNot - str
    '''
    computerNumber = generateNumber()
    userNumber = userEnterNumber()
    while userNumber != 12345:
        bull = calculateBullAndCow(userNumber,computerNumber)
        while bull != 4 and userNumber != 12345:
            userNumber = userEnterNumber()
            bull = calculateBullAndCow(userNumber,computerNumber)
        if userNumber != 12345:
            print("Congratulations!")
        break
    if userNumber == 12345:
        print(computerNumber)
    playOrNot = input('Do you want to play a new game or exit? Enter "play" or "exit": ')
    return playOrNot
     
def generateNumber():
    '''
    Generate a random number with four unique digits.
    Parameters:
    None
    Variables:
    a(int) - a random number between 1 and 9, and it is different from other digits
    b(int) - a random number between 1 and 9, and it is different from other digits
    c(int) - a random number between 1 and 9, and it is different from other digits
    d(int) - a random number between 1 and 9, and it is different from other digits
    number(int) - a random number with four unique digits
    Return:
    number - int
    '''
    a=random.randint(1,9)
    b=random.randint(1,9)
    c=random.randint(1,9)
    d=random.randint(1,9)
    while a==b or a==c or a==d:
        a=random.randint(1,9)
    while b==a or b==c or b==d:
        b=random.randint(1,9)
    while c==a or c==b or c==d:
        c=random.randint(1,9)
    while d==a or d==b or d==c:
        d=random.randint(1,9)
    number=a*1000+b*100+c*10+d
    return number

def userEnterNumber():
    '''
    Ask the user to enter his or her guess about the 4-digit number. The user could choose to end the game \
    or enter a random secret 4-digit number.
    Parameters:
    None
    Variables:
    userNumber(str/int) - the number the user enters
    Return:
    userNumber - int
    '''
    userNumber=input('Enter your guess (you can enter "exit" to exit the game): ')
    if userNumber=="exit":
         userNumber = 12345         
    else:
         userNumber=int(userNumber)
         while (userNumber//1000)==0 or (userNumber%10)==0 or (userNumber%100)//10==0 or (userNumber%1000)//100==0 or (userNumber//1000)==(userNumber%10)\
               or userNumber//1000==(userNumber%100)//10 or userNumber//1000==(userNumber%1000)//100 or userNumber%10==(userNumber%100)//10 or\
               (userNumber%10)==(userNumber%1000)//100 or (userNumber%100)//10==(userNumber%1000)//100:
               userNumber=input("Enter a valid number with 4 unique digits or exit: ")
               if userNumber=="exit":
                   userNumber = 12345
               else:
                   userNumber = int(userNumber)
    return userNumber

def calculateBullAndCow(userNumber,computerNumber):
     '''
     Compare the user's number with the computer' number. If the matching digits are in the right positions, they are bulls, \
     and if in different positions, they are cows.
     Parameters:
     userNumber(int) - the 4-digits number the user generates
     computerNumber(int) - the 4-digits number with unique number in each position randomly generated by computer
     Variables:
     aU(int) - the kilobit of user's number
     aU(int) - the hundred's place of user's number
     aU(int) - the decade of user's number
     aU(int) - the unit of user's number
     cU(int) - the kilobit of computer's number
     cU(int) - the hundred's place of computer's number
     cU(int) - the decade of computer's number
     cU(int) - the unit of computer's number
     bull(int) - the number of digits that are in the exact right positions
     cow(int) - the number of matching digits that are in different positions
     Return:
     bull - int
     '''
     aU = userNumber//1000
     bU = (userNumber%1000)//100
     cU = (userNumber%100)//10
     dU = userNumber%10
     bull=0
     cow=0
     aC = computerNumber//1000
     bC = (computerNumber%1000)//100
     cC = (computerNumber%100)//10
     dC = computerNumber%10
     if aU==aC:
         bull=bull+1
     elif aU==bC or aU==cC or aU==dC:
         cow=cow+1
     if bU==bC:
         bull=bull+1
     elif bU==aC or bU==cC or bU==dC:
         cow=cow+1
     if cU==cC:
         bull=bull+1
     elif cU==aC or cU==bC or cU==dC:
         cow=cow+1
     if dU==dC:
         bull=bull+1
     elif dU==aC or dU==bC or dU==cC:
         cow=cow+1
     if userNumber != 12345:
         print("You got ",bull," bull")
         print("You got ",cow," cow")
     return bull


main()
    
