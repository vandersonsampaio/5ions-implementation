package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.service.interfaces.service.ICorrelationService;
import org.springframework.stereotype.Service;

@Service
public class CorrelationService implements ICorrelationService {

    @Override
    public void computeCorrelationAdherence() {
        logger.debug("Calculate Correlation");
    }

    @Override
    public void computeCorrelationCoefficient() {
        logger.debug("Compute Correlation");
    }
}
