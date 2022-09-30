package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.service.interfaces.service.IAnnotationService;
import org.springframework.stereotype.Service;

@Service
public class AnnotationService implements IAnnotationService {

    @Override
    public void annotate() {
        logger.debug("Annotate");
    }
}
