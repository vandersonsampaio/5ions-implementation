package br.ufsc.ine.ppgcc.model.summarization;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentSummarized {

    public String id;
    public String title;
    public String content;
    public String language;
    public String summary;
}
