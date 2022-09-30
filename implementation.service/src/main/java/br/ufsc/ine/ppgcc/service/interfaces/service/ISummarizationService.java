package br.ufsc.ine.ppgcc.service.interfaces.service;

import br.ufsc.ine.ppgcc.model.request.SummarizationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ISummarizationService {

    Logger logger = LoggerFactory.getLogger(ISummarizationService.class);

    void summarize(SummarizationRequest request);
}
