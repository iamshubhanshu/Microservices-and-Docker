FROM openjdk:8
EXPOSE 8761
ADD target/product-service.jar Eureka-service.jar
ENTRYPOINT ["java", "-jar", "/Eureka-service.jar"]