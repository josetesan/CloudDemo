FROM anapsix/alpine-java:jre8
ADD target/*.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx96m","-Xss256k","-jar","/app.jar"]