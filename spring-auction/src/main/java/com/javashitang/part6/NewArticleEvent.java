package com.javashitang.part6;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class NewArticleEvent extends ApplicationEvent {

    private String authorName;
    private String articleName;

    public NewArticleEvent(Object source, String authorName, String articleName) {
        super(source);
        this.authorName = authorName;
        this.articleName = articleName;
    }

}
