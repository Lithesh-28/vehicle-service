# Step 1: Use OpenJDK image as base
FROM openjdk:21-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the jar file into the container
COPY target/vehicle-service-0.0.1-SNAPSHOT.jar vehicle-service.jar

# Step 4: Expose the port used by your application
EXPOSE 8081

# Step 5: Run the jar file
ENTRYPOINT ["java", "-jar", "vehicle-service.jar"]
