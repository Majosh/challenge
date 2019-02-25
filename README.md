# To Run the code
1. Download the zip file or pull from the repository
1. Open the project using Eclipse Photon Release (4.8.0) or later
1. Run the project as Java Application
1. All log files that the system generates will be created at the root folder of the project which includes __bad-data-<timestamp>.csv__ and __log.txt__.
  
# Approach to Solve the Challenge

To solve the challenge i used opencsv library for reading the content of CSV and hibernate library to connect in the SQLite database.As advised from the guidelines, Maven is also used to manage the dependencies of these libraries.

The application is divided into 4 classes, TechnicalTest as the Main Class, XtableServices as the service class that handles database connection and transactions, Xtable as the entity class that represents the database table and double qouted the elements, lastly Process Class contains the logic of the application like, retrieval of data from csv, saving records, validating bad data and logging the statistic log.
