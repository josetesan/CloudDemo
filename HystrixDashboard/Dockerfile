FROM anapsix/alpine-java:jre8
ADD target/*.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 7000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]