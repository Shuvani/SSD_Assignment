# SSD_Assignment
This is the photo stock contest system implemented using patterns and OOP.

### Prerequisites

This is project build with [Maven](https://maven.apache.org/).

You can download and install Maven from [here](https://maven.apache.org/download.cgi)
or use default package manager of your system.

This project can be build using default tools inside Idea but there is a problem with determing root directory (Idea and Maven interpret it differently). Therefore it is better to build the project using Maven.

## Build

To build this project simply run

```
mvn compile
```

This command will fetch all dependencies, compile the project and generate one additional folder (`target`) in the root of the project.

## Run

To run this project, you can create `.jar` file and execute it:

``` 
mvn package
java -jar target/<FILE_NAME>.jar
```
