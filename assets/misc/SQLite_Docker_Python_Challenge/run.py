print("Hello world!")
from flask_script import Manager
from webservice2 import app, db, Intern, Position
import datetime

manager = Manager(app)


# reset the database and create some initial data
@manager.command
def deploy():
    db.drop_all()
    db.create_all()
    position= Position(name="Software Development Intern", description="This position is for software development intern")
    intern1 = Intern(last_name='A',first_name='B', position_applied='Software Development Intern', school='GWU', program='Computer Science',date_of_entry=datetime.datetime.now())
    intern2 = Intern(last_name='B',first_name='A', position_applied='Data Science Intern', school='GWU', program='Computer Science',date_of_entry=datetime.datetime.now())
    db.session.add(position)
    db.session.add(intern1)
    db.session.add(intern2)
    db.session.commit()


if __name__ == "__main__":
    manager.run()
