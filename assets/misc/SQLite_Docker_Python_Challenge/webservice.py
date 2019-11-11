import os
import flask
import datetime
from flask import Flask, session, render_template, request, flash, redirect, url_for, jsonify
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SECRET_KEY'] = 'hard to guess secure key'

# setup SQLAlchemy
basedir = os.path.abspath(os.path.dirname(__file__))
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + os.path.join(basedir, 'data.sqlite')
db = SQLAlchemy(app)

class Intern(db.Model):
    __tablename__ = 'interns'
    id = db.Column(db.Integer, primary_key=True)
    last_name = db.Column(db.String(64))
    first_name = db.Column(db.String(64))
    position_applied = db.Column(db.String(64))
    school = db.Column(db.String(64))
    program = db.Column(db.String(64))
    date_of_entry = db.Column(db.Text)
    """def __init__(last_name, first_name, position_applied, school, program):
        self.last_name = last_name
        self.first_name = first_name
        self.position_applied = position_applied
        self.school=school
        self.program=program
        self.date_of_entry=datetime.datetime.now()"""

class Position(db.Model):
    __tablename__ = 'positions'
    name = db.Column(db.Text, primary_key=True)
    description = db.Column(db.Text)
    """def __init__(name, description):
        self.name=name
        self.description=description"""

# song-all.html adds song id to the edit button using a hidden input

@app.route('/')
def index():
    # return HTML
    # return "<h1>this is the home page!<h1>"
    return render_template('home-base.html')

@app.route('/positions')
def show_all_positions():
    positions = Position.query.all()
    return render_template('position-all.html', positions=positions)


@app.route('/position/add', methods=['GET', 'POST'])
def add_positions():
    if request.method == 'GET':
        return render_template('position-add.html')
    if request.method == 'POST':
        # get data from the form
        name = request.form['name']
        description = request.form['description']
        position = Position(name=name, description=description)

        # insert the data into the database
        db.session.add(position)
        db.session.commit()
        return redirect(url_for('show_all_positions'))

# song-all.html adds song id to the edit button using a hidden input
@app.route('/interns')
def show_all_interns():
    interns = Intern.query.all()
    return render_template('intern-all.html', interns=interns)


@app.route('/intern/add', methods=['GET', 'POST'])
def add_interns():
    if request.method == 'GET':
        positions = Position.query.all()
        return render_template('intern-add.html', positions=positions)
    if request.method == 'POST':
        # get data from the form
        last_name=request.form['last_name']
        first_name = request.form['first_name']
        position_applied = request.form['position_applied']
        school = request.form['school']
        program = request.form['program']
        position = Position.query.filter_by(name=position_applied).first()
        intern = Intern(last_name=last_name, first_name=first_name, position_applied=position, school=school, program=program)

        # insert the data into the database
        db.session.add(intern)
        db.session.commit()
        return redirect(url_for('show_all_interns'))

# https://goo.gl/Pc39w8 explains the following line
if __name__ == '__main__':

    # activates the debugger and the reloader during development
    # app.run(debug=True)
    app.run()

    # make the server publicly available on port 80
    # note that Ports below 1024 can be opened only by root
    # you need to use sudo for the following conmmand
    # app.run(host='0.0.0.0', port=80)
