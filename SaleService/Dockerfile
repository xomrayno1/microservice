FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} SaleService.jar

ENTRYPOINT [ "java", "-jar", "/SaleService.jar" ]

EXPOSE 9001