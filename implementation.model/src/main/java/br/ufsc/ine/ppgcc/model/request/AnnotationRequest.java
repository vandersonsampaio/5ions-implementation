package br.ufsc.ine.ppgcc.model.request;

import br.ufsc.ine.ppgcc.model.enumerable.Language;
import br.ufsc.ine.ppgcc.model.enumerable.TypeDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnnotationRequest {

    private String id;
    private String content;
    private TypeDocument type;
    private Language language;
}
