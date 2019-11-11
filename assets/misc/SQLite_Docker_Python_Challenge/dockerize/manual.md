# How user should enter the data into the database

## first of all, define the database that you want to enter data in:
### an example would be like database = r"interns.db", you can replace the interns.db
### within the double quotes with the name of your database

## Then we connect the database we will be operating on by calling
## conn = create_connection(database)


## If you want to drop current table or create new table in the database:
## example query for dropping table:
### sql_drop_positions_table="""
###                             DROP TABLE positions
###                              """
### you can just change the variable name and the positions to the table name that you
### want to drop
### and then you call drop_table(conn, sql_drop_interns_table) and change the ### sql_drop_interns_table to the name of the query you defined above.

## If you want to create a new table in the current database:
## example query for creating new table:
### sql_create_positions_table = """ CREATE TABLE IF NOT EXISTS positions (
###                                        name text PRIMARY KEY,
###                                        description text
###                                    ); """

## Remember to use self.conn.commit() to commit the changes into the database


### you can just change the variable name and the positions to the table name that you
### want to create. You can also edit the values/features in the table by adding
### variable name and type inside the parenthesis
### Then you call create_table(conn, sql_create_positions_table) and change
### sql_create_positions_table to the name of the query you defined above

## Now we have the tables we want, and we want to insert data into the table

### we define new data object based on the database requirement. For example, because
### position table only requires two variables, name and description, when we are
### defining a new position variable that we want to insert into positions table, we
### first define the variable as position=("Software Development Intern", "This
### position is for software development intern") and you can change the name of the
### variable, attributes of the variable. Then you call create_position(conn,
### position) to insert this new variable/data into the database.


## If you want to insert multiple interns at the same time:
### You should make a list of the interns, each as an dictionary, with 'Applicant
### Last Name', 'Applicant First Name', 'Position Applied For', 'Applicant School'
### and 'Applicant Degree Program' as the keys in the dictionary and enter the
### corresponding values for each interns as the values of the dictionary
### Then you call create_interns_api(self.conn, interns) and replace interns with the
### name of the list variable that you just created


## Don't forget to use self.conn.commit() to commit the changes into the database


## FYI use self.conn.close() to close the connection afterwards
