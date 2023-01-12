FROM openjdk:8-jdk-alpine

EXPOSE 8082

ADD target/Achat-1.0.war Achat-1.0.war

ENTRYPOINT ["java","-jar","/Achat-1.0.war"]