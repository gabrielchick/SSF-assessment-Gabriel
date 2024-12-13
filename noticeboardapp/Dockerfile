FROM eclipse-temurin:23-noble AS builder

WORKDIR /src

# copy files
COPY mvnw .
COPY pom.xml .

COPY .mvn .mvn
COPY src src

# make mvnw executable
RUN chmod a+x mvnw && /src/mvnw package -Dmaven.test.skip=true
# /src/target/revision-0.0.1-SNAPSHOT.jar

FROM eclipse-temurin:23-jre-noble

WORKDIR /app

COPY --from=builder /src/target/ssf-b5-assessment-0.0.1-SNAPSHOT.jar app.jar

# check if curl command is available
RUN apt update && apt install -y curl

ENV PORT=8080

EXPOSE ${PORT}

HEALTHCHECK --interval=60s --start-period=120s\
   CMD curl http://localhost:${PORT}/health || exit 1

ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar