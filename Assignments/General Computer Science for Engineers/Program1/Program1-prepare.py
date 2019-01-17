#Peiyu Wang, Ruxia Qin
import math
import random


def main():
    displayWelcomeMessage()
    playOrNot = input('Do you want to play a new game or exit? Enter "play" or "exit": ')
    while playOrNot == "play":
        playOrNot = playTheGame()
    print("Game ends.")



def displayWelcomeMessage():
    print("Welcome to the game!")
    print("Here are the instructions: first the computer generates a number and asks for your input, \
if your guess has one digit on its right position, you have one bull, \
if you get several digits right, but not in right position, you will get as many cows as the right digits. \
Then it will ask you to type in a number again until you get the right one. You can also exit whenever you want.")

def playTheGame():
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
    
