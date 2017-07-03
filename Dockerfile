FROM java:8

COPY . /usr/src/phone-book
WORKDIR /usr/src/phone-book

RUN ./mvnw install -DskipTests=true

CMD ["./mvnw", "jetty:run"]
