#-----------------------------------------------------------------------
# CityCorp Project
#-----------------------------------------------------------------------
# This project does not require any WEB Container to expose REST services
# Due to this configuration just one class (Resource) has been marked with REST tags.



#-----------------------------------------------------------------------
# DB Configuration
#-----------------------------------------------------------------------

No special configuration is needed to set up the DB.
This project use Derby embedded as DB Manager, this means,
the DB runs in the same JVM as this project.

# DB location
The DB files will be stored in the root of this project
/CC-Project
    /src
    /target
    /database



#-----------------------------------------------------------------------
# RUN PROJECT
#-----------------------------------------------------------------------


# Compile project
> mvn clean install dependency:copy-dependencies

# Run project
> java -cp target/CityCorp.jar;target/dependency/* Main


# Console Output: 
Initializing HTTP server...
ene 19, 2019 10:37:46 AM org.glassfish.jersey.internal.Errors logErrors
WARNING: The following warnings have been detected: WARNING: The (sub)resource method init in resources.Resource contains empty path annotation.

Server started!
Initializing Derby...
Derby is running!
:::CityCorp Project ready:::


#-----------------------------------------------------------------------
# TEST SERVICES
#-----------------------------------------------------------------------

# To call services from a browser use following links
http://localhost:8084/resources
http://localhost:8084/resources/user/1



# To execute services from command line with cURL
curl --request GET http://localhost:8084/resources
curl --request GET http://localhost:8084/resources/user/1


#-----------------------------------------------------------------------
# WHAT ACTIONS DOES THIS PROJECT PERFORM WHEN IT IS EXECUTED?
#-----------------------------------------------------------------------

1. Initialize HTTP Server
2. Initialize Derby DB
    2.1 Open a connection to Derby
    2.2 Create Tables (user, project, requirement)
        2.2.1 If tables already exists, log will display a message and tables won't be created
    2.3 Insert 5 default users to User Table
        2.3.1 For the second time this project is executed, default users won't be inserted
