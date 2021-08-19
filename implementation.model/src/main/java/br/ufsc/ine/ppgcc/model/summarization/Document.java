package br.ufsc.ine.ppgcc.model.summarization;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document implements Serializable {

    public String id;
    public String title;
    public String content;
    public String language;
}
