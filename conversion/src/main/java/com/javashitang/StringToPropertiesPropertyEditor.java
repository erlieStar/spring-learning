package com.javashitang;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * @author lilimin
 * @since 2021-03-20
 */
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport {

    // 1. 实现setAsText(String)方法
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // 2. 将String类型转换成Properties类型
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        // 3. 临时存储Properties对象
        setValue(properties);
    }


    @Override
    public String getAsText() {
        Properties properties = (Properties) getValue();
        StringBuilder textBuilder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            textBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
        }
        return textBuilder.toString();
    }
}
