package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.model.request.SummarizationRequest;
import br.ufsc.ine.ppgcc.service.interfaces.service.ISummarizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SummarizationService implements ISummarizationService {

    @Value("${rabbit.queues.producer.exchange.summarization.document}")
    private String exchangeName;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void summarize(SummarizationRequest request) {
        logger.debug("Summarize. s={}", request.getId());
        rabbitTemplate.convertAndSend(exchangeName, request.getId(), request);
    }
}
