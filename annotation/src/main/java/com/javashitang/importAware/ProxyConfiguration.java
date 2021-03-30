package com.javashitang.importAware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lilimin
 * @since 2021-03-30
 */
@Configuration
public class ProxyConfiguration implements ImportAware {

    private AnnotationAttributes info;

    @Bean
    public ProxyMode proxyMode() {
        ProxyMode proxyMode = new ProxyMode();
        proxyMode.setMode(info.getString("mode"));
        return proxyMode;
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.info = AnnotationAttributes.fromMap(
                importMetadata.getAnnotationAttributes(EnableProxy.class.getName(), false));
    }
}
