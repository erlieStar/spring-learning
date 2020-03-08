package com.javashitang.part6;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NewArticleEventListener implements ApplicationListener<NewArticleEvent> {

    @Override
    public void onApplicationEvent(NewArticleEvent event) {
        System.out.println(event.getAuthorName() + " 发了一篇文章 " + event.getArticleName());
    }
}
