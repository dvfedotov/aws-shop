FROM adoptopenjdk/openjdk11
EXPOSE 8085 5005
MAINTAINER aws
COPY target/aws-0.0.1-SNAPSHOT.jar /deployments/
WORKDIR /deployments/
CMD ["java","-jar","/deployments/aws-0.0.1-SNAPSHOT.jar"]
