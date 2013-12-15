Collab
=======
This project is a demonstration simplified data exchanged between server and client.
I'm using a straightforward JSON to persist the client object into the db.

Status
-----
Dead, to be removed ..

Development stopped before a first alpha release, because of time and priority changes...

This application demonstrates how tricky it is to develop an application with GWT.
The GWT stack is pretty complex to manage. I do not think it is a good match for building "simple application".
I would rather use HTML5 + Knockout.js + Java7 backend to build a good web application.

Goals
-------
 - 50% test coverage on the client.
 - 100% test coverage on the server.
 - Write the application with ORM and without ORM

Technologies
-------

GWT 2.4
-------
Framework to build advanced web application in java.

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

Testing
----

JUnit 4.10
------
Excellent java testing framework
http://junit.org

Mockito
-----
Mock object on the server side.
http://code.google.com/p/mockito/

Power Mockito
-----
Mock the not-mocketable !
http://code.google.com/p/powermock

Framework underline.
--------
In this example I try to demonstrate how a web application can be created highly efficiently.
- MongoDB Driver for JAVA to manage the database.
- RequestBuilder and AutoBean to perform all the communication and the object transformation.
- Injection to limit the number of line need.

