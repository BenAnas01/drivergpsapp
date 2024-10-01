# Use a base image with Java 17
FROM eclipse-temurin:21

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/drivergpsappdemo-0.0.1-SNAPSHOT.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
