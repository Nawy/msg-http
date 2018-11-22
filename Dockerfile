FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/msg-http-0.0.1-SNAPSHOT-standalone.jar /msg-http/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/msg-http/app.jar"]
