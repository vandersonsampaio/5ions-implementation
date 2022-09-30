package br.ufsc.ine.ppgcc.model;

import br.ufsc.ine.ppgcc.model.enumerable.Language;
import br.ufsc.ine.ppgcc.model.enumerable.TypeDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Document implements Serializable {

    private String id;
    private String title;
    private String content;
    private TypeDocument type;
    private Language language;
    private String url;

}
