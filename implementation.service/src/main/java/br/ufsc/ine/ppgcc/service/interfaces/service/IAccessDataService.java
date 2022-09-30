package br.ufsc.ine.ppgcc.service.interfaces.service;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.model.SummarizedDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IAccessDataService {

    Logger logger = LoggerFactory.getLogger(IAccessDataService.class);

    void saveSummarization(SummarizedDocument document);
    void saveOriginalDocument(Document document);
    void saveAnnotatedDocument();
}
