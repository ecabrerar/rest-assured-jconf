# rest-assured-jconf

## Clone the repository
```bash 
git clone https://github.com/ecabrerar/rest-assured-jconf.git
cd rest-assured-jconf
```


## Move to project directory

Example with **rest-assured-jconfcolombia** directory:
```bash 
cd rest-assured-jconfcolombia
```


## Build the project
```bash 
mvn clean  package -DskipTests && java -jar ./target/rest-assured-jconfcolombia-thorntail.jar
```

## Example with **rest-assured-jconfdominicana** directory:
```bash 
cd rest-assured-jconfdominicana
mvn package -DskipTests && java -jar ./target/rest-assured-jconfdominicana-thorntail.jar
```

## Open your browser at the following url:
http://localhost:8080/jconfcolombia/sessions

All the sessions must be shown.

**Notice:** if you are running **rest-assured-jconfcolombia** the url of the endpoint is http://localhost:8080/jconfcolombia/sessions and if you are running **rest-assured-jconfdominicana** the url is http://localhost:8080/jconfdominicana/sessions

Also, you can do the same using curl

Open a terminal
```bash 
curl http://localhost:8080/jconfcolombia/sessions
```

### Now, open the project using your favorite IDE with maven support and execute the test cases
