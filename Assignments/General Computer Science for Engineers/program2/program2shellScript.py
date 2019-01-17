Python 3.4.3 (v3.4.3:9b73f1c3e601, Feb 23 2015, 02:52:03) 
[GCC 4.2.1 (Apple Inc. build 5666) (dot 3)] on darwin
Type "copyright", "credits" or "license()" for more information.
>>> WARNING: The version of Tcl/Tk (8.5.9) in use may be unstable.
Visit http://www.python.org/download/mac/tcltk/ for current information.
================================ RESTART ================================
>>> 
Welcome to Music Database!
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: s
Enter the name of the file that has the song records: songs.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: a
Enter the name of the file that has the artist records: artists.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: t
Enter the name of the file that has the top 10 data: top10.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: l
Enter the name of the file that has the sales records: sales.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: p
Enter the table name: songs
     Song title       Artist stage name  
-------------------- -------------------
Watch Me             Silento             
Locked Away          R. City             
Cheerleader          Omi                 
Wildest Dreams       Taylor Swift        
Good For You         Selena Gomez        
Can't Feel My Face   The Weeknd          
Hotline Bling        Drake               
679                  Fetty Wap           
The Hills            The Weeknd          
What Do You Mean     Justin Bieber       
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: p
Enter the table name: artists
 Artist stage name                Name                         Hometown           
-------------------- ----------------------------- -----------------------------
Drake                Aubrey Drake Graham            Toronto, Ontario              
Fetty Wap            Willie Maxwell                 Paterson, NJ                  
Omi                  Omar Samuel Pasley             Clarendon, Jamaica            
The Weeknd           Abel Tesfaye                   Toronto, Ontario              
Silento              Ricky Lamar Hawk               Atlanta, GA                   
R. City              Theron and Timothy Thomas      St. Thomas, Virgin Islands    
Justin Bieber        Justin Drew Bieber             Stratford, Ontario            
Taylor Swift         Taylor Alison Swift            Wyomissing, PA                
Selena Gomez         Selena Marie Gomez             Grand Prairie, TX             
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: p
Enter the table name: top10
Rank Song title          
---- -------------------
 1   The Hills           
 2   What Do You Mean    
 3   Can't Feel My Face  
 4   Hotline Bling       
 5   Watch Me            
 6   679                 
 7   Locked Away         
 8   Good For You        
 9   Cheerleader         
 10  Wildest Dreams      
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: q
Enter a query: select * from songs where songTitle='Watch Me'
     Song title       Artist stage name  
-------------------- -------------------
Watch Me             Silento             
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: select * from artists where stageName='Taylor Swift'
Invalid choice. Please try again: q
Enter a query: select * from artists where stageName='Taylor Swift'
 Artist stage name                Name                         Hometown           
-------------------- ----------------------------- -----------------------------
Taylor Swift         Taylor Alison Swift            Wyomissing, PA                
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: c

>>> ================================ RESTART ================================
>>> 
Welcome to Music Database!
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: s
Enter the name of the file that has the song records: songs.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: a
Enter the name of the file that has the artist records: artists.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: t
Enter the name of the file that has the top 10 data: top10.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: l
Enter the name of the file that has the sales records: sales.txt
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: w
s: load songs
a: load artists
t: load top 10
l: load sales
p: print a table – songs, artists, top10
q: query database - songs, artists
c: sales chart
w: write database to a file
e: exit the program
Enter a choice: e
>>> 
