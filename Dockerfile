FROM java:8
WORKDIR /
ADD target/exercise-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "exercise-0.0.1-SNAPSHOT.jar"]