FROM adoptopenjdk:11-jre-hotspot
COPY ideas-0.0.6.jar /tmp/
WORKDIR /tmp
CMD ["java", "-jar", "ideas-0.0.6.jar"]
