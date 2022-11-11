FROM openjdk:8
EXPOSE 9004
ADD target/product-service.jar cart-service.jar
ENTRYPOINT ["java", "-jar", "/cart-service.jar"]