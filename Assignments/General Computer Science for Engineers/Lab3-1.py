##Q1

def sumOfDigits(String):
    sumNumber=0
    for i in range(0,len(String)):
        if String[i].isdigit():
            sumNumber=sumNumber+int(String[i])
    return sumNumber


##Q2

def smallerThanN(intList,integer):
    newList=[]
    for intInList in intList:
        if intInList<integer:
            newList.append(intInList)
    return newList

assertEqual(smallerThanN([2,5,8,15,58,3,4],8),[2,5,3,4])
assertEqual(smallerThanN([],8),[])
assertEqual(smallerThanN([5,4,3,2,1],3),[2,1])

##Q3
def sumNegativeInts(List):
    sumInts=0
    for i in List:
        if i<0:
            sumInts+=i
    return sumInts

assertEqual(sumNegativeInts([2, 1, -5, 0]),-5)
assertEqual(sumNegativeInts([-1, 1, -9, 1]),-10)
assertEqual(sumNegativeInts([9, 2, -7, 7]),-7)
assertEqual(sumNegativeInts([]),0)

##Q4
def reverseList(List):
    newList=[]
    for i in range(len(List)-1,-1,-1):
        content=List[i]
        newList.append(content)
    return newList
assertEqual(reverseList([1,2,3,4,5]),[5,4,3,2,1])
assertEqual(reverseList([]),[])
assertEqual(reverseList([1,4,7,5,10]),[10,5,7,4,1])

##Q5

def sentenceCapitalizer(String):
    newString=String.split(". ")
    secondNewString=""
    if len(String)==0:
        return ""
    for i in range(0,len(newString)):
        stringWord=newString[i]
        secondNewString+=stringWord[0:1].upper()+stringWord[1:]
        if(i<len(newString)-1):
            secondNewString+=". "
    return secondNewString
assertEqual(sentenceCapitalizer("hello. my name is Joe. what is your name?"),"Hello. My name is Joe. What is your name?")
assertEqual(sentenceCapitalizer("it's Friday. what is your plan?"),"It's Friday. What is your plan?")
assertEqual(sentenceCapitalizer("write a function. don't forget test cases."+" and comments also."),"Write a function. Don't forget test cases. And comments also.")
assertEqual(sentenceCapitalizer("this is a one sentence string."),"This is a one sentence string.")
assertEqual(sentenceCapitalizer(""),"")

##Lab 3-2
def main():
    integerList=input("Enter a list of integers: ")
    integer=int(input("Enter an integer: "))
    newList=integerList.split(",")
    secondNewList=[]
    for i in range(len(newList)):
        if newList[i]!=",":
           secondNewList.append(int(newList[i]))
    secondNewList=smallerThanN(secondNewList,integer)
    print(secondNewList)
main()

def main():
    inputList=input("Enter a list of integers seperated by commas with no spaces: ")
    newList=inputList.split(",")
    secondNewList=[]
    for i in range(len(newList)):
        while not newList[i].lstrip("-").isdigit():
                  inputList=input("Enter a list of integers again: ")
        secondNewList.append(int(newList[i]))
    sum=sumNegativeInts(secondNewList)
    print(sum)
main()
