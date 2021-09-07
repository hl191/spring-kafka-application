# spring-kafka-application

UI Tool for Kafka: [Offset Explorer](https://kafkatool.com/download.html)

## How to use:
1. Make Kafka and Zookeeper available locally:
    ```bash
    docker-compose up
    ```
2. Run the application
3. Send messages to the controller via REST
    ```bash
    curl -X 'POST' http://localhost:8080/send?message=ThisIsAMessage
    ```

## Shutdown and remove created volumes
```bash
docker-compose down -v
```

## Current features:
- Producer exposed over REST
- The message `error` will result in a `RuntimeException`
- Exceptions on consumption will be published to the topics DLT (Dead LeTter)
- Exception messages from the DLT are consumed as well and logged with their stacktrace.