package br.ufsc.ine.ppgcc.consumer;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.service.interfaces.IFiveIonsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumers {

    private final Logger logger = LoggerFactory.getLogger(Consumers.class);

    private final IFiveIonsManager manager;

    public Consumers(IFiveIonsManager manager) {
        this.manager = manager;
    }

    @RabbitListener(queues = {"${rabbit.queues.consumer.queue.document.input}"})
    public void firstQueueListener(@Payload Document document) {
        logger.debug("Document received: d={}", document.getTitle());
        manager.start(document);
    }

    @RabbitListener(queues = {"${rabbit.queues.consumer.queue.document.original}"})
    public void originalQueueListener(@Payload Document document) {
        logger.debug("Original Document received: d={}", document.getId());
        manager.firstStep(document);
    }
}
