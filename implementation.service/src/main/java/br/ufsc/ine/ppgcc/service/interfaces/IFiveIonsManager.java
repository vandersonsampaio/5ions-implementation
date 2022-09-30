package br.ufsc.ine.ppgcc.service.interfaces;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.model.request.AnnotationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IFiveIonsManager {

    Logger logger = LoggerFactory.getLogger(IFiveIonsManager.class);

    void start(Document document);
    void firstStep(Document document);
    void summarization(Document document);
    void annotationStep(AnnotationRequest request);
    void calculation();
    void computeCorrelationAdherence();
    void calculateCorrelationCoefficient();
    void predict();
    void trainPredictor();
}
