#-----------------------------------------------------------------------
# CityCorp Project
#-----------------------------------------------------------------------
# This project does not require any WEB Container to expose REST services
# Due to this configuration just one class (Resource) has been marked with REST tags.


#-----------------------------------------------------------------------
# STEPS TO RUN PROJECT
#-----------------------------------------------------------------------

# > Run MySQL Service
# In a console go to the directory .../mysql-folder/bin
# execute the command: mysqld

# Run "query.sql" file to create DB, Tables (User table includes an insert for a default user)

# > Update parameters for connection to DB
# Open the DataBase class and update the user and password properties according 
# to you local configuration.
# By default mysql runs on port 3306


# > Compile and download dependencies
mvn clean install dependency:copy-dependencies

# > Add dependencies to classpath and execute Main class
java -cp target/CityCorp.jar;target/dependency/* Main

# Console Output: 
::: Initializing server.
ene 08, 2019 2:23:20 PM org.glassfish.jersey.internal.Errors logErrors
WARNING: The following warnings have been detected: WARNING: The (sub)resource method init in resources.Resource contains empty path annotation.
 
::: Server started.


# Test demo REST services:
#-----------------------------------------------------------------------
http://localhost:8084/resources
http://localhost:8084/resources/user/admin


#-----------------------------------------------------------------------
# OSLC
#-----------------------------------------------------------------------

# The class OSLCResource includes a brief introduction (non-functional)

