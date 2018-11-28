FROM java:8-alpine

COPY target/uberjar/luminus-spike.jar /luminus-spike/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luminus-spike/app.jar"]
