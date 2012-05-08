Collab
=======
This project is a demonstration simplified data exchanged between server and client.
I'm using a straightforward JSON to persist the client object into the db.

Goals
-------
 - 50% test coverage on the client.
 - 100% test coverage on the server.
 - write the application with ORM and without ORM

Technologies
-------

GWT 2.4
-------
Framework for the server side.

GIN
---
Automatic dependency injection to Google Web Toolkit client-side code.
http://code.google.com/p/google-gin/

MongoDB Driver
---
Document oriented database (noSQL).
http://mongodb.org

Morphia
----
ORM like for mongoDB.
http://code.google.com/p/morphia

Framework underline.
--------
In this example I try to demonstrate how a web application can be created highly efficiently.
- MongoDB Driver for JAVA to manage the database.
- RequestBuilder and AutoBean to perform all the communication and the object transformation.
- Injection to limit the number of line need.

