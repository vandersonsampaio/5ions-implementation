package br.ufsc.ine.ppgcc.service;

import br.ufsc.ine.ppgcc.client.DocumentClient;
import br.ufsc.ine.ppgcc.client.AnnotationClient;
import br.ufsc.ine.ppgcc.client.EntityClient;
import br.ufsc.ine.ppgcc.model.Entity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnnotationService {

    private final DocumentClient documentClient;
    private final EntityClient entityClient;
    private final AnnotationClient annotationClient;

    public AnnotationService(DocumentClient documentClient, EntityClient entityClient, AnnotationClient annotationClient){
        this.documentClient = documentClient;
        this.entityClient = entityClient;
        this.annotationClient = annotationClient;
    }

    public void annotationNewsDocuments(long startTime, long endTime){
        Map<Long, String> documents = documentClient.getDocumentsWithoutAnnotationEntities(startTime, endTime);
        Map<Long, List<Entity>> annotatedDocuments = annotationEntities(documents);
        entityClient.putAnnotationEntities();

        documents = documentClient.getDocumentsWithoutSentiments(startTime, endTime);
        Map<Long, Map<Long, Double>> annotatedSentiments = annotationSentiments(documents);
        entityClient.putSentiments(annotatedSentiments);

        documents = documentClient.getDocumentsWithoutEntitiesSentiment(startTime, endTime);
        Map<Long, List<Entity>> annotatedEntitiesSentiment = annotationEntitiesSentiment(documents);
        entityClient.putEntitiesSentiment();
    }

    public Map<Long, List<Entity>> annotationEntities(Map<Long, String> mapDocuments){
        return annotationClient.entity(mapDocuments);
    }

    public Map<Long, Map<Long, Double>> annotationSentiments(Map<Long, String> mapDocuments){
        return annotationClient.sentiment(mapDocuments);
    }

    public Map<Long, List<Entity>> annotationEntitiesSentiment(Map<Long, String> mapDocuments){
        return annotationClient.sentimentEntity(mapDocuments);
    }
}
