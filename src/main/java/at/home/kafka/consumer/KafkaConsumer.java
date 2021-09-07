package at.home.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${message.topic.name}")
    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        LOGGER.info("Received message '{}' in topic '{}' ", message, topic);
        if (message.equalsIgnoreCase("error")) {
            throw new IllegalStateException();
        }
    }

    @KafkaListener(topics = "${message.topic.name}.DLT")
    public void handleDeadLetterQueue(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.DLT_EXCEPTION_STACKTRACE) String exceptionStackTrace) {
        LOGGER.error("There is one new dead-letter record with value '{}' in topic '{}'", message, topic);
        LOGGER.error("exceptionStackTrace: {}", exceptionStackTrace);
    }
}
