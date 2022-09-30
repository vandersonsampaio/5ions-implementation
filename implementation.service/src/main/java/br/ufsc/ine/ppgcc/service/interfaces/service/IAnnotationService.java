package br.ufsc.ine.ppgcc.service.interfaces.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IAnnotationService {

    Logger logger = LoggerFactory.getLogger(IAnnotationService.class);

    void annotate();
}
