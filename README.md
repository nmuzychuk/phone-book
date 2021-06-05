# Phone Book
[![Java CI with Maven](https://github.com/nmuzychuk/phone-book/actions/workflows/maven.yml/badge.svg)](https://github.com/nmuzychuk/phone-book/actions/workflows/maven.yml)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a436f52fdccc454bb08e0a5e07c6260a)](https://www.codacy.com/app/nmuzychuk/phone-book)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/a436f52fdccc454bb08e0a5e07c6260a)](https://www.codacy.com/app/nmuzychuk/phone-book)

## Overview
A simple telephone directory built with Servlet API, JSP and JDBC

## Run
```
./mvnw jetty:run
```

## Docker
```
docker build -t phone-book .
docker run -p 8080:8080 phone-book
```

## Test
Run JUnit tests
```
./mvnw test
```

## License
This project is released under the [MIT License](LICENSE.txt)
