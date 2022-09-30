package br.ufsc.ine.ppgcc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SummarizedDocument {

    private Document document;
    private String summary;
}
