package br.ufsc.ine.ppgcc.service.implementation.service;

import br.ufsc.ine.ppgcc.client.SummarizationClient;
import br.ufsc.ine.ppgcc.model.summarization.Document;
import br.ufsc.ine.ppgcc.model.summarization.DocumentSummarized;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;

import java.util.Collections;
import java.util.List;

public class SummarizationService {

    private final SummarizationClient client;

    public SummarizationService() {
        client = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(SummarizationClient.class))
                .logLevel(Logger.Level.FULL)
                .target(SummarizationClient.class, "http://127.0.0.1:5000");
    }

    public String summarize() {
        List<Document> documents = Collections.singletonList(Document.builder()
                .id("Id 123")
                .title("Título da Matéria")
                .content("A relação do Brasil com a China, especialmente nos processos de compras de equipamentos e insumos para vacinas, deve ser o tema central do depoimento nesta terça-feira do ex-ministro de Relações Exteriores Ernesto Araújo à CPI da Covid. Diferente do ex-titular da Saúde Eduardo Pazuello, Araújo não pediu habeas corpus para ficar em silêncio e sua defesa afirma que ele está tranquilo para explicar as ações de sua gestão. Mas já mostrando um descolamento, o Itamaraty tem buscado destacar as relações com o país asiático e em uma audiência no Senado um representante da pasta defendeu a necessidade de 'louvar a China' pela atitude na pandemia.")
                .language("Portuguese")
                .build());

        List<DocumentSummarized> documentsSummarized = client.summarize(documents);

        return documentsSummarized.stream().findFirst().get().summary;
    }
}
