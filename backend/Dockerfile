FROM maven:3.8.1-openjdk-11 as maven

RUN mkdir -p /air-labs-challenge

WORKDIR /air-labs-challenge

COPY ./pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./src ./src 

RUN mvn package -DskipTests

FROM openjdk:11-jre

WORKDIR /air-labs-challenge

EXPOSE 8080

COPY --from=maven air-labs-challenge/target/AirLabsChallenge-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]