# README #

This application is built with Spring boot. 
The application runs at port 8084.

### Assumption
High traffic volume

### Requirement

1. Java 1.8+ JRE
2. Java 1.8+ JDK for development
3. gradle

### How do I get set up? ###

1. Download the source code from the git hub
2. And set up System environment variables for connecting to external API
```
MEDICAL_API=
```


3. go to project root and run the following command to generate the artifact.
`./gradlew clean build`

You can skip testing by running 
`./gradlew clean build -x test`

4. You can run the application by the following command if you set the system variables.
`java -jar /project/root/build/libs/report-0.0.0.0.jar`

Otherwise, you add `-DMEDICAL_URL=`  in the command.

Alternative, you can run it via your IDE.
The main class is 
`sydney.hospital.report.ReportApplication`

### Deployment

You can run the application as service.
In linux 
```[Unit]
   Description=report
   
   [Service]
   User=[user]
   Group=[group]
   EnvironmentFile=[FILE_PATH]
   ExecStart=/usr/bin/java -jar -Xms64M -Xmx256M /path/report-0.0.0.0.jar
   ExecReload=/bin/kill -s HUP $MAINPID
   ExecStop=/bin/kill -S TERM $MAINPID
   #Restart=on-failure
   PrivateTmp=true
   [Install]
   WantedBy=multi-user.target

```


### Feature

Swagger documentation 
h2 database console `/h2-console`
JDBC URL `jdbc:h2:mem:testdb`

### Demo
Demo API : `http://188.166.243.95:8084`

Swagger documentation 
`http://188.166.243.95:8084/swagger-ui.html`

Health check endpoint
`/actuator/health`

You can access the application at port 8084.

### Efficiency

The efficiency of the calculation  is O(n^2).

