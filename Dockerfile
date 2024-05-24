# Use a Maven image to build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and the source code to the working directory
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use an OpenJDK runtime image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/your-app-name.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]