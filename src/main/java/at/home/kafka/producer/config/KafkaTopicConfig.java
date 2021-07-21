package at.home.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${message.topic.name}")
    private String topicName;

    @Bean
    public NewTopic topic1() {
        return new NewTopic(topicName, 1, (short) 1);
    }
}
