package br.ufsc.ine.ppgcc.service.interfaces.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ICalculationService {

    Logger logger = LoggerFactory.getLogger(ICalculationService.class);
    void calculate();
}
