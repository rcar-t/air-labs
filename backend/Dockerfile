FROM maven:3.8.1-openjdk-11 as maven

COPY ./pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./src ./src 

RUN mvn package -DskipTests

FROM openjdk:11-jre

WORKDIR /air-labs-challenge

COPY --from=maven target/AirLabsChallenge-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]