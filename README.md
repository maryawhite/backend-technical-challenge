# backend-technical-challenge
Using Java and PostgreSQL create a Person Class and Job Class. Add functionality to be able to add, get, update, and delete a person.
Person should have the following fields:
    
- id
- name
- age
- dateJoined
- dateUpdated

live site displaying json data: https://json-backend-technical.herokuapp.com/api/person
 (note this is a free server and may take a minute to load)
 
Bonus--create a class called Job with the following fields:
- id
- jobTitle
- salary
    
You should be able to add, get, update, and delete a job, get all jobs, and you should be able to update an existing person's job.

Write a small SQL seeder file to add some people and jobs to the database.

Set up automated tests to test your endpoints.

# PostgreSQL

You must have PostgreSQL installed on your macbook

from the IntelliJ terminal, type psql

list the databases

    \l
    
create a new database

    CREATE DATABASE nameofyour_db;

    GRANT ALL PRIVILEGES ON DATABASE "nameofyour_db" TO yourusername;

    GRANT ALL PRIVILEGES ON DATABASE "nameofyour_db" TO postgres;

# Test your mapping in IntelliJ

to test your mapping in IntelliJ, next to your GetMapping or PostMapping, you will see an icon that looks like a globe with a dropdown arrow. Click the dropdown and select generate request in http client.

<img width="627" alt="Screen Shot 2022-02-20 at 5 09 20 PM" src="https://user-images.githubusercontent.com/88731567/154866525-50e9fc90-3cdd-4f61-b30c-40994e1abed8.png">

<img width="707" alt="Screen Shot 2022-02-20 at 5 12 59 PM" src="https://user-images.githubusercontent.com/88731567/154866633-17dd4af4-eeea-4613-96b9-f08be1eb2662.png">

# Heroku Setup

1. In your pom file add the plugin 		

<img width="502" alt="plugin" src="https://user-images.githubusercontent.com/88731567/155657423-8852693e-e4d5-4c08-85ec-2047982df740.png">

2. Create a **system.properties** file with this line: **java.runtime.version=11**. Your app will not build without this
3. You must have a heroku account, and have the heroku CLI installed
4. Create a new app on heroku
5. In IntelliJ terminal enter: heroku git:remote -a name-of-your-app
6. Find the name of your database (it's not the same as your local db, to find it enter \conninfo. Or look at your Config Vars on heroku, its the very end of the value
7. enter \dt  to look for tables
8. If your table is not there, you'll need to manually create the table in the terminal. (Tip: if the table is already set up in your local environment in IntelliJ, you can open the database tab, control click on the table, SQL Scripts, SQL Generator and then copy the code to create your table)
9. If you have a seeder file, manually insert the values into the table.
10. When you're ready to push, make sure you're on main, git add -A, git commit - m "your comments" git push origin main, then git push heroku main


