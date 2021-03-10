package com.javashitang.part6;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    @EventListener
    public void newArticleEventListener(NewArticleEvent event) {
        System.out.println(event.getAuthorName() + " 发了一篇文章 " + event.getArticleName());
    }
}
