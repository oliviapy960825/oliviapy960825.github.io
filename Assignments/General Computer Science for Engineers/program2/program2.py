import pylab
def welcomeAndInstructions():
  '''
  Show a welcome message and instructions.
  '''
  print("Welcome to Music Database!")
  print("s: load songs\na: load artists\nt: load top 10\nl: load sales\np: print a table – songs, artists, top10\n\
q: query database - songs, artists\nc: sales chart\nw: write database to a file\ne: exit the program")

def getMenuOption():
  '''
  Prompt the user with a menu for input.
  Variable:
  menuOption(str) - user's choice
  Returen:
  menuOption
  '''
  menuOption = input("Enter a choice: ")
  while menuOption not in ["s","a","t","l","p","q","c","w","e"]:
    menuOption = input("Invalid choice. Please try again: ")
  return menuOption

def createDictionary(fileName, separator):
  '''
  Help convert content in one file to a dictionary.
  Parameters:
  fileName(str) - the name of the file that needs to be converted
  separator(str) - the separator in the file that used to separate different data
  Variables:
  filePrt - open the file
  dictionary(dict) - one dictionary used to contain content in the file
  line - lines in the file without "\n"
  data - different data that is seperated by the seperator
  Return:
  dictionary
  '''
  filePtr = open(fileName,'r')
  dictionary = {}
  for line in filePtr:
    line = line.strip()
    data = line.split(separator)
    dictionary[data[0]]=data
  return dictionary

def loadSongs():
  '''
  Prompt the user for the name of the file that has the song records.
  Variable:
  fileName(str) - the file name the user enters
  Return:
  createDictionary(fileName, "|") - call a function using the variable user enters
  '''
  fileName = input("Enter the name of the file that has the song records: ")
  return createDictionary(fileName, "|")

def loadArtists():
  '''
  Prompt the user for the name of the file that has the artist records.
  Variable:
  fileName(str) - the file name the user enters
  Return:
  createDictionary(fileName, "|") - call a function using the variable user enters
  ''' 
  fileName = input("Enter the name of the file that has the artist records: ")
  return createDictionary(fileName, "|")

def loadSales():
  '''
  Prompt the user for the name of the file that has the sales records.
  Variable:
  fileName(str) - the file name the user enters
  Return:
  createDictionary(fileName, "|") - call a function using the variable user enters
  '''
  fileName = input("Enter the name of the file that has the sales records: ")
  return createDictionary(fileName, ",")

def loadTop10():
  '''
  Prompt the user for the name of the file that has the top 10 records to be loaded into the top10 table in the database.
  Variables:
  fileName(str) - the file name the user enters
  filePrt - open the file
  listOfTop(list) - the list of top 10 songs
  line - lines in the file without "\n"  
  Return:
  listOfTop
  '''
  fileName = input("Enter the name of the file that has the top 10 data: ")
  filePtr = open(fileName,'r')
  listOfTop = []
  for line in filePtr:
    line = line.strip()
    listOfTop.append(line)
  return listOfTop



def printSongsTable():
  '''
  Print a table of songs.
  Variables:
  songs(dict) - the dictionary of datas in the file songs
  listSongs(list) - the list of values in the dictionary
  '''
  print("Song title".center(20), "Artist stage name".center(20))
  print("--------------------", "-------------------")
  listSongs = list(songs.values())
  printSong(listSongs)

def printSong(listSongs):
  '''
  Use recursion to print all the values in the list.
  Parameter:
  listSongs(list) - a list of songs and artist stage name
  '''
  if (len(listSongs) > 0):
    print((listSongs[0][0]).ljust(20), (listSongs[0][1]).ljust(20))
    printSong(listSongs[1:])


def printArtistsTable():
  '''
  Print a table of artists.
  Variables:
  artists(dict) - the dictionary of datas in the file artists
  listArtists(list) - the list of values in the dictionary
  '''
  print("Artist stage name".center(20), "Name".center(30),"Hometown".center(30))
  print("--------------------", "-----------------------------","-----------------------------")
  listArtists = list(artists.values())
  printArtist(listArtists)

def printArtist(listArtists):
  '''
  Use recursion to print all the values in the list.
  Parameter:
  artists(list) - a list of artist stage name, artist name, and hometown
  '''
  if (len(listArtists) > 0):
    print((listArtists[0][0]).ljust(20), (listArtists[0][1]).ljust(30),(listArtists[0][2]).ljust(30))
    printArtist(listArtists[1:])

def printTop10Table():
  '''
  Print a table of top 10 songs.
  Variables:
  top10(list) - the list of top 10 songs' title
  '''
  print("Rank".center(4), "Song title".ljust(20))
  print("----", "-------------------")
  printTop10Song(top10, 1)

def printTop10Song(top10, rank):
  '''
  Use recursion to print all the values in the list.
  Parameter:
  top10(list) - a list of songs and their rank
  Rank(int) - the rank of songs
  '''
  if (len(top10) > 0):
    print(str(rank).center(4),(top10[0]).ljust(20))
    printTop10Song(top10[1:],rank+1)

def printSalesTable():
  '''
  Print a table of sles.
  Variables:
  sales(dict) - the dictionary of datas in the file songs
  listSales(list) - the list of values in the dictionary
  '''
  print("Song title".center(20), "Amount".center(6),"Amount".center(6),"Amount".center(6),"Amount".center(6))
  print("--------------------", "------","------","------","------")
  listSales = list(sales.values())
  printSale(listSales)

def printSale(listSales):
  '''
  Use recursion to print all the values in the list.
  Parameter:
  printSale(list) - a list of songs' title and their sales
  '''
  if (len(listSales) > 0):
    print((listSales[0][0]).ljust(20), (listSales[0][1]).center(6),\
          (listSales[0][2]).center(6),(listSales[0][3]).center(6),(listSales[0][4]).center(6))
    printSale(listSales[1:])







def printATable():
  '''
  Ask the user to enter a table name and call other functions to print the table.
  Variabes:
  tableName(str) - the name that user enters
  '''
  tableName = input("Enter the table name: ")
  while tableName not in ["songs","artists","top10"]:
    tableName = input("Invalid table name. Plese try again: ")
  if tableName == "songs":
    printSongsTable()
  elif tableName == "artists":
    printArtistsTable()
  else:
    printTop10Table()



def query():
  query = input("Enter a query: ")
  tableName = query[(query.index("from")+5):(query.index("where")-1)]
  primaryKey = query[query.index("=")+2:].strip("'")
  if tableName == "songs":
    print("Song title".center(20), "Artist stage name".center(20))
    print("--------------------", "-------------------")
    printSong([songs[primaryKey]])
  elif tableName == "artists":
    print("Artist stage name".center(20), "Name".center(30),"Hometown".center(30))
    print("--------------------", "-----------------------------","-----------------------------")
    printArtist([artists[primaryKey]])


def salesChart():
  xaxis=[0,1,2,3]
  songTitleTuple = tuple(sales.keys())
  salesList = list(sales.values())
  salesDate=['8/27/2015','9/3/2015','9/10/2015','9/17/2015']
  for index in range(len(salesList)):
    pylab.xticks(xaxis, salesDate)
    pylab.plot(xaxis,salesList[index][1:])
  pylab.legend(songTitleTuple)
  pylab.show()


def writeToFile():
  filePtr = open('musicLibrary.txt','w')
  songList = list(songs.values())
  for song in songList:
    songTitle=song[0]
    artist=artists[song[1]]
    sale=sales[songTitle]
    filePtr.write(songTitle+"|"+str(top10.index(songTitle)+1)+"|"+artist[0]+"|"\
                  +artist[1]+"|"+artist[2]+"|"+sale[len(sale)-1]+"\n")
  filePtr.close()



welcomeAndInstructions()
menuOption = getMenuOption()
while menuOption != 'e':
  if menuOption == 's':
    songs = loadSongs()
  elif menuOption == 'a':
    artists = loadArtists()
  elif menuOption == 't':
    top10 = loadTop10()
  elif menuOption == 'l':
    sales = loadSales()
  elif menuOption == 'p':
    printATable()
  elif menuOption == 'q':
    query()
  elif menuOption == 'c':
    salesChart()
  elif menuOption == 'w':
    writeToFile()
  else:
    print("Goodbye!")
    break
  print("s: load songs\na: load artists\nt: load top 10\nl: load sales\np: print a table – songs, artists, top10\n\
q: query database - songs, artists\nc: sales chart\nw: write database to a file\ne: exit the program")
  menuOption = getMenuOption()
















