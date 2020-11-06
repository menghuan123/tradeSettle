FROM openjdk:8-alpine

ADD starter/target/scaffold-starter-0.0.1-SNAPSHOT.jar /data/app/

WORKDIR /data/app/

ENTRYPOINT ["java","-jar","scaffold-starter-0.0.1-SNAPSHOT.jar"]