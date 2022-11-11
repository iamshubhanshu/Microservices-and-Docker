FROM openjdk:8
EXPOSE 8099
ADD target/product-service.jar API-service.jar
ENTRYPOINT ["java", "-jar", "/API-service.jar"]