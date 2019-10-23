package com.law.kg.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "kg_yl")
@Data
public class Knowledge {
    @Indexed(unique=true)
    private String question;
    private String answer;
    private Integer number;
    private String big;
    private String small;
}
