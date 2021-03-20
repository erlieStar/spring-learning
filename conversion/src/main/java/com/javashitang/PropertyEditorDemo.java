package com.javashitang;

import java.beans.PropertyEditor;

/**
 * @author lilimin
 * @since 2021-03-20
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        String text = "name = 小识";
        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        propertyEditor.setAsText(text);
        System.out.println(propertyEditor.getValue());
        System.out.println(propertyEditor.getAsText());
    }
}
