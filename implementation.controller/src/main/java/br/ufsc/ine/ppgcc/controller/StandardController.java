package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.interfaces.IFiveIonsManager;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StandardController {

    Logger logger = LoggerFactory.getLogger(StandardController.class);

    private final IFiveIonsManager manager;

    public void trainPredictor() {
        logger.debug("Train Predictor");
        manager.trainPredictor();
    }

    public void calculateCorrelation() {
        logger.debug("Calculate Correlation");
        manager.calculateCorrelationCoefficient();
    }
}
