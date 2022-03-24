# FROM adoptopenjdk/openjdk15:ubi
# ENV APP_HOME=/usr/app/
# WORKDIR $APP_HOME


# COPY target/original-back-end-service-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080
# CMD ["java", "-jar", "app.jar"]

FROM adoptopenjdk/openjdk15:ubi


WORKDIR /usr/app

#RUN mvn install

COPY target/back-end-service-0.0.1-SNAPSHOT.jar /usr/app/
COPY . .
RUN sh -c 'touch back-end-service-0.0.1-SNAPSHOT.jar'

EXPOSE 8090
ENTRYPOINT ["java","-jar","back-end-service-0.0.1-SNAPSHOT.jar"]