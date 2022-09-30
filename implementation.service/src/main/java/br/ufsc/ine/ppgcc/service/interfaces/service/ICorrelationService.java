package br.ufsc.ine.ppgcc.service.interfaces.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ICorrelationService {

    Logger logger = LoggerFactory.getLogger(ICorrelationService.class);

    void computeCorrelationAdherence();
    void computeCorrelationCoefficient();
}
