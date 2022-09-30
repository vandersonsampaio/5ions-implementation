package br.ufsc.ine.ppgcc.consumer;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConsumerConfig {

    @Bean
    public Declarables consumerBindings(@Value("${rabbit.queues.consumer.queue.input}") String inputQueueName,
                                        @Value("${rabbit.queues.consumer.queue.document.original}") String originalQueueName) {
        Queue inputQueue = new Queue(inputQueueName, false);
        Queue originalQueue = new Queue(originalQueueName, false);

        return new Declarables(inputQueue, originalQueue);
    }
}
