FROM openjdk:11.0
ADD target/achat-1.0.jar achat-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]