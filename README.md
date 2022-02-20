# backend-technical-challenge
Using Java and PostgreSQL create a Person Class and Job Class. Add functionality to be able to add, get, update, and delete a person.
Person should have the following fields:
    
- id
- name
- age
- dateJoined
- dateUpdated

Job should have the following fields:
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


