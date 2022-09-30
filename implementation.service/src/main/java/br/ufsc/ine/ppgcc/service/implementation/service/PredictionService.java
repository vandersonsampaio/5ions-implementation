package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.service.interfaces.service.IPredictionService;
import org.springframework.stereotype.Service;

@Service
public class PredictionService implements IPredictionService {

    @Override
    public void calculatePrediction() {
        logger.debug("Calculate Prediction");

    }

    @Override
    public void trainPredictor() {
        logger.debug("Train Predictor");
    }
}
