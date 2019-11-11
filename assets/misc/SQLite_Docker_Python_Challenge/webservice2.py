import sqlite3
from sqlite3 import Error
import datetime
import os
from flask import Flask, session, render_template, request, flash, redirect, url_for, jsonify
from flask_sqlalchemy import SQLAlchemy

def create_connection(db_file):
    """ create a database connection to the SQLite database
        specified by db_file
    :param db_file: database file
    :return: Connection object or None
    """
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        return conn
    except Error as e:
        print(e)

    return conn


def create_table(conn, create_table_sql):
    """ create a table from the create_table_sql statement
    :param conn: Connection object
    :param create_table_sql: a CREATE TABLE statement
    :return:null
    """
    try:
        c = conn.cursor()
        c.execute(create_table_sql)
    except Error as e:
        print(e)

def drop_table(conn,drop_table_sql):
    """
    Drop possible tables before creating a new opened
    :param conn: Connection object
    :param drop_table_sql: a DROP TABLE statement
    :return: null
    """
    try:
        c = conn.cursor()
        c.execute(drop_table_sql)
    except Error as e:
        print(e)

def create_position(conn, position):
    """
    Create a new position into the positions table
    :param conn:
    :param position:
    :return: null
    """
    sql = ''' INSERT INTO positions(name,description)
              VALUES(?,?) '''
    cur = conn.cursor()
    cur.execute(sql, position)
    conn.commit()


def create_intern(conn, intern):
    """
    Create a new intern
    :param conn:
    :param intern:
    :return: intern id
    """

    sql = ''' INSERT INTO interns(last_name,first_name,position_applied,school,program,date_of_entry)
              VALUES(?,?,?,?,?,?) '''
    cur = conn.cursor()
    cur.execute(sql, intern)
    conn.commit()
    return cur.lastrowid


def create_interns_api(conn, json_data_packet):
    """
    Create a new intern
    :param conn:
    :param json_data_packet
    :return: null
    """
    for i in json_data_packet:
        intern=(i.get('Applicant Last Name'),i.get('Applicant First Name'),i.get('Position Applied For'),i.get('Applicant School'),i.get('Applicant Degree Program'),datetime.datetime.now())
        create_intern(conn,intern)
        conn.commit()


def main():
    """
    In this main function, we connect to the database, and we create position table and intern table
    and after that we create new position and new interns and insert the data into the position/intern
    table
    """
    database = r"interns.db"
    sql_drop_positions_table="""
                                DROP TABLE positions
                                """
    sql_drop_interns_table="""
                                DROP TABLE interns
                                """
    sql_create_positions_table = """ CREATE TABLE IF NOT EXISTS positions (
                                        name text PRIMARY KEY,
                                        description text
                                    ); """

    sql_create_interns_table = """CREATE TABLE IF NOT EXISTS interns (
                                    id integer PRIMARY KEY,
                                    last_name text NOT NULL,
                                    first_name text NOT NULL,
                                    position_applied text NOT NULL,
                                    school text NOT NULL,
                                    program text NOT NULL,
                                    date_of_entry text NOT NULL,
                                    FOREIGN KEY (position_applied) REFERENCES positions (name)
                                    ON UPDATE NO ACTION
                                );"""

    # create a database connection
    conn = create_connection(database)


    # create tables
    if conn is not None:
        #drop interns table before everything else
        drop_table(conn, sql_drop_interns_table)

        #drop positions table before everything else
        drop_table(conn, sql_drop_positions_table)

        # create projects table
        create_table(conn, sql_create_positions_table)
        # create tasks table
        create_table(conn, sql_create_interns_table)
    else:
        print("Error! cannot create the database connection.")

    with conn:
        #create position-later on change the check condition
        position=("Software Development Intern", "This position is for software development intern");
        create_position(conn, position)


        #create interns:
        intern_1=("A","B","Software Development Intern","GWU","Data Analytics",datetime.datetime.now())
        intern_2=("C","D","Software Development Intern","GWU","Data Analytics",datetime.datetime.now())

        create_intern(conn,intern_1)
        create_intern(conn,intern_2)
    conn.commit()
    conn.close()
    return database


"""
From here down is the part that I have not yet finished- showing the values in the database on the webpage
and allow user to insert new values into the database via the webpage
"""
app = Flask(__name__)
app.debug = True
#app.config['SECRET_KEY'] = 'hard to guess secure key'

# setup SQLAlchemy
basedir = os.path.abspath(os.path.dirname(__file__))
#app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + os.path.join(basedir, 'data.sqlite')
#db = SQLAlchemy(app)
db=main()
conn = create_connection(db)
mycur = conn.cursor()



# setup SQLAlchemy

@app.route('/')
def index():
    """
    This leads user to the home base page when the app runs
    """
    # return HTML
    # return "<h1>this is the home page!<h1>"
    return render_template('home-base.html')

@app.route('/positions')
def show_all_positions():
    """
    This leads user to the position page when user clicks on the positions
    button on the top right and it is supposed to show user all the positions
    in the database
    """
    db=main()
    conn = create_connection(db)
    mycur = conn.cursor()
    post=mycur.execute("SELECT * FROM positions")
    #positions = positions.query.all()
    return render_template('position-all.html', positions=post)


@app.route('/position/add', methods=['GET', 'POST'])
def add_positions():
    """
    This leads user to the position adding page when user clicks on the add positions
    button it is supposed to let user enter and add new positions into the database
    """
    if request.method == 'GET':
        return render_template('position-add.html')
    if request.method == 'POST':
        # get data from the form
        name = request.form['name']
        description = request.form['description']
        #position = Position(name=name, description=description)
        position=(name, description);
        create_position(conn, position)
        # insert the data into the database
        #db.session.add(position)

        return redirect(url_for('show_all_positions'))


@app.route('/interns')
def show_all_interns():
    """
    This leads user to the position page when user clicks on the interns
    button on the top right and it is supposed to show user all the interns
    in the database

    """
    db=main()
    conn = create_connection(db)
    mycur = conn.cursor()
    interns = mycur.execute("SELECT * FROM interns")
    return render_template('intern-all.html', interns=interns)


@app.route('/intern/add', methods=['GET', 'POST'])
def add_interns():
    """
    This leads user to the position adding page when user clicks on the add interns
    button it is supposed to let user enter and add new interns into the database
    """
    if request.method == 'GET':
        db=main()
        conn = create_connection(db)
        mycur = conn.cursor()
        positions=mycur.execute("SELECT * FROM positions")
        return render_template('intern-add.html', positions=positions)
    if request.method == 'POST':
        # get data from the form
        db=main()
        conn = create_connection(db)
        mycur = conn.cursor()
        positions=mycur.execute("SELECT * FROM positions")
        last_name=request.form['last_name']
        first_name = request.form['first_name']
        position_applied = request.form['position_applied']
        school = request.form['school']
        program = request.form['program']
        position = positions.query.filter_by(name=position_applied).first()
        intern = (last_name, first_name, position, school, program, datetime.datetime.now())
        create_intern(conn,intern)
        # insert the data into the database
        #db.session.add(intern)
        #db.session.commit()
        return redirect(url_for('show_all_interns'))





if __name__ == '__main__':
    main()
    #app.run()
