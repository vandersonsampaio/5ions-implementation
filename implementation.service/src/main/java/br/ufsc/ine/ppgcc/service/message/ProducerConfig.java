package br.ufsc.ine.ppgcc.service.message;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    public Declarables producerBindings(@Value("${rabbit.queues.producer.exchange.data}") String exchange,
                                @Value("${rabbit.queues.producer.queue.data.save}") String queueName) {
        Queue queue = new Queue(queueName, false);

        FanoutExchange fanoutExchange = new FanoutExchange(exchange, false, false);

        return new Declarables(queue, fanoutExchange, BindingBuilder.bind(queue).to(fanoutExchange));
    }
}
