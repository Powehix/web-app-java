# About
This is an inventory web application developed as part of an undergraduate paper.
This application implements CRUD functionality to interact with the database and also allows you to generate and print QR codes.

## Getting Started
Connection to the database is described in the file application.properties. 
Please change the installed settings to work with your database, in particular, you must change the hostname, password, database ID and port.

*Note: MySQL must be used as the DBMS.*

Connected dependecies:
- ZXing
- mysql

Connected dependencies are described in the file pom.xml.

Use [this](https://github.com/Powehix/mobile-app-dart) mobile app to scan the generated QR codes and conduct inventory.
