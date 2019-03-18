FROM alpine:latest
RUN apk --update add openjdk8-jre
COPY hellobootweb-0.0.1-SNAPSHOT.jar hellobootweb.jar
CMD ["java", "-jar","hellobootweb.jar"]