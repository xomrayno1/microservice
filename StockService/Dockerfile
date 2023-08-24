FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} StockService.jar

ENTRYPOINT [ "java", "-jar", "/StockService.jar" ]

EXPOSE 9003