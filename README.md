
# Calculator RESTful API

This project is a  RESTful API that provides the basic functionalities of a calculator.

## Features

- Addition, subtraction, multiplication and division for 2 operands only
- Support for decimal numbers
- 1 module (module name: rest) to  handle incoming requests and return responses
- 1 module (module name: calculator) to execute a mathematical calculation
- Kafka broker to communicate between modules
- Logs for events and errors

## Run

Prerequisites:
- Docker
- Docker Compose

Clone the project:

```bash
  git clone https://github.com/joaormorais/calculator-spring-boot-api.git
```

Inside the "CalculatorAPI" folder, you will find 2 .yml files that are going to be used to start the apache kafka broker, and the modules "rest" and "calculator".

First, start the kafka broker:

```bash
  docker compose -f docker-compose.broker.yml up -d
```

Before starting the containers with the modules, you need the images. Go to the "rest" folder and create the image for the "rest" module:

```bash
  cd rest
  docker build -t rest-module .
```

Return to the "CalculatorAPI" folder, go to the "calculator" folder and create the image for the "calculator" module:

```bash
  cd ..
  cd calculator
  docker build -t calculator-module .
```

Return to the "CalculatorAPI" folder, and start the containers with the modules "rest" and "calculator".

```bash
  docker compose -f docker-compose.modules.yml up -d
```

**If you want to run the project on IntelliJ, you only need to start the broker. The modules can be started on the IDE.**
## Tech Stack

| Layer                   | Technology              |
| ----------------------- | ----------------------- |
| Programming Language    | Java         |
| Framework               | Spring Boot  |
| Communication           | Apache Kafka |
| Containerization        | Docker       |

## Authors

- [@joaormorais](https://github.com/joaormorais)
