package br.ufsc.ine.ppgcc.service.implementation;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.model.request.AnnotationRequest;
import br.ufsc.ine.ppgcc.service.interfaces.IFiveIonsManager;
import br.ufsc.ine.ppgcc.service.interfaces.service.IAccessDataService;
import br.ufsc.ine.ppgcc.service.interfaces.service.IAnnotationService;
import br.ufsc.ine.ppgcc.service.interfaces.service.ICalculationService;
import br.ufsc.ine.ppgcc.service.interfaces.service.ICorrelationService;
import br.ufsc.ine.ppgcc.service.interfaces.service.IPredictionService;
import br.ufsc.ine.ppgcc.service.interfaces.service.ISummarizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class FiveIonsManager implements IFiveIonsManager {

    @Value("${5ions.summarization.enable:true}")
    private boolean enableSummarization;

    private final ISummarizationService summarizationService;
    private final IAnnotationService annotationService;
    private final ICalculationService calculationService;
    private final ICorrelationService correlationService;
    private final IPredictionService predictionService;
    private final IAccessDataService dataService;

    @Override
    public void start(Document document) {
        logger.debug("Start Process. d={}", document.getTitle());
        dataService.saveOriginalDocument(document);
    }

    @Override
    public void firstStep(Document document) {
        if (enableSummarization) {
            summarization(document);
        } else {
            annotationStep(null);
        }
    }

    @Override
    public void summarization(Document document) {
        logger.debug("Summarization step. d={}", document.getId());
        summarizationService.summarize(null);
    }

    @Override
    public void annotationStep(AnnotationRequest request) {
        logger.debug("Annotation step. d={}", request.getId());
        annotationService.annotate();
    }

    @Override
    public void calculation() {
        calculationService.calculate();
    }

    @Override
    public void computeCorrelationAdherence() {
        correlationService.computeCorrelationAdherence();
    }

    @Override
    public void calculateCorrelationCoefficient() {
        correlationService.computeCorrelationCoefficient();
    }

    @Override
    public void predict() {
        predictionService.calculatePrediction();
    }

    @Override
    public void trainPredictor() {
        predictionService.trainPredictor();
    }
}
