FROM openjdk:14-alpine
COPY build/libs/microservice-template-*-all.jar microservice-template.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "microservice-template.jar"]