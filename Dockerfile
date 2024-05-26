# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy only the necessary files for dependency resolution to leverage layer caching
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar /app/api.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/api.jar"]
