package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.model.SummarizedDocument;
import br.ufsc.ine.ppgcc.service.interfaces.service.IAccessDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccessDataService implements IAccessDataService {

    @Value("${rabbit.queues.producer.exchange.data}")
    private String exchangeSaveOriginalName;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void saveSummarization(SummarizedDocument document) {
        //Publish in queue
        logger.debug("Save summarizations");
    }

    @Override
    public void saveOriginalDocument(Document document) {
        logger.debug("Save original Documents");
        rabbitTemplate.convertAndSend(exchangeSaveOriginalName, document.getUrl(), document);
    }

    @Override
    public void saveAnnotatedDocument() {
        logger.debug("Save annotated Documents");
    }
}
