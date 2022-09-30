package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.service.interfaces.service.ICalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationService implements ICalculationService {

    @Override
    public void calculate() {
        logger.info("Calculate");
    }
}
