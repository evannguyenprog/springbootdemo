FROM adoptopenjdk:11-jre-hotspot
COPY target/springbootdemo-*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
