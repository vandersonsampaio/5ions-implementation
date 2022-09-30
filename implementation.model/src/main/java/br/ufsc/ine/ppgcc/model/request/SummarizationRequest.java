package br.ufsc.ine.ppgcc.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SummarizationRequest {

    private String id;
    private String content;
}
