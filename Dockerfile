FROM adoptopenjdk:11-jre-hotspot
COPY ideas-0.0.1.jar /tmp/
WORKDIR /tmp
CMD ["java", "-jar", "/tmp/ideas-0.0.1.jar"]