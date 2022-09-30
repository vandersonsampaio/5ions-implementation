package br.ufsc.ine.ppgcc.service.interfaces.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IPredictionService {

    Logger logger = LoggerFactory.getLogger(IPredictionService.class);

    void calculatePrediction();
    void trainPredictor();
}
