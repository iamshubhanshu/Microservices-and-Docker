FROM openjdk:8
EXPOSE 9003
ADD target/product-service.jar price-service.jar
ENTRYPOINT ["java", "-jar", "/price-service.jar"]