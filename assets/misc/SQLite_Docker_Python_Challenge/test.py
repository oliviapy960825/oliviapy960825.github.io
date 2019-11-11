import sqlite3
import unittest
from webservice2 import *
import warnings
import datetime

#warnings.simplefilter("ignore", ResourceWarning)


class UnitTest(unittest.TestCase):
    def setUp(self):
        self.conn = sqlite3.connect(":memory:")
        c = self.conn.cursor()

    def test_creating_table(self):
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



        #c.execute(sql_create_positions_table)

        # create projects table
        create_table(self.conn, sql_create_positions_table)

        # create tasks table
        create_table(self.conn, sql_create_interns_table)
        self.conn.commit()

        res = self.conn.execute("SELECT name FROM sqlite_master WHERE type='table';")
        names=res.fetchall()
            #result=self.assertEqual(name[0],"positions") or self.assertEqual(name[1],"interns")
            #print (str(result))
        self.assertTrue(names[0], "positions")
        self.assertTrue(names[1], "interns")

            #Creating table tested
        # create tables

    # Returns True or False.
    def test_inserting_position(self):
        position=("Software Development Intern", "This position is for software development intern")
        if self.conn is not None:
            c = self.conn.cursor()
            sql_create_positions_table = """ CREATE TABLE IF NOT EXISTS positions (
                                                name text PRIMARY KEY,
                                                description text
                                            ); """
            create_table(self.conn, sql_create_positions_table)
            create_position(self.conn, position)
            self.conn.commit()
        else:
            print("Error! cannot create the database connection.")

        c.execute("SELECT name from positions LIMIT 1")
        result = c.fetchone()
        self.assertTrue(result[0], "Software Development Intern")

    def test_inserting_intern(self):
        intern_1=("A","B","Software Development Intern","GWU","Data Analytics",datetime.datetime.now())
        intern_2=("C","D","Data Science Intern","GWU","Data Analytics",datetime.datetime.now())
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



        #c.execute(sql_create_positions_table)


        if self.conn is not None:
            c = self.conn.cursor()
            # create projects table
            create_table(self.conn, sql_create_positions_table)

            # create tasks table
            create_table(self.conn, sql_create_interns_table)
            position=("Software Development Intern", "This position is for software development intern")
            create_position(self.conn, position)
            create_intern(self.conn, intern_1)
            create_intern(self.conn, intern_2)
            self.conn.commit()
        else:
            print("Error! cannot create the database connection.")

        c.execute("SELECT first_name from interns")
        result = c.fetchall()
        self.assertTrue(len(result), 1)
        self.assertTrue(result[0], "B")

    def test_inserting_intern_api(self):
        #intern_1=("A","B","Software Development Intern","GWU","Data Analytics",datetime.datetime.now())
        #intern_2=("C","D","Data Science Intern","GWU","Data Analytics",datetime.datetime.now())
        interns=[{'Applicant Last Name':'A','Applicant First Name':'B','Position Applied For':'Software Development Intern','Applicant School':'GWU','Applicant Degree Program':'CS'},{'Applicant Last Name':'C','Applicant First Name':'D','Position Applied For':'Data Analytics Intern','Applicant School':'GWU','Applicant Degree Program':'CS'}]
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



        #c.execute(sql_create_positions_table)


        if self.conn is not None:
            c = self.conn.cursor()
            # create projects table
            create_table(self.conn, sql_create_positions_table)

            # create tasks table
            create_table(self.conn, sql_create_interns_table)
            position=("Software Development Intern", "This position is for software development intern")
            create_position(self.conn, position)
            create_interns_api(self.conn, interns)
            self.conn.commit()
        else:
            print("Error! cannot create the database connection.")

        c.execute("SELECT first_name from interns")
        result = c.fetchall()
        self.assertTrue(len(result), 1)
        self.assertTrue(result[0], "B")

    def tearDown(self):
        self.conn.close()
if __name__ == '__main__':
    unittest.main()
