FROM openjdk:8

ADD maven/spring-boot-mongodb-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test","-jar","/myapp.jar"]