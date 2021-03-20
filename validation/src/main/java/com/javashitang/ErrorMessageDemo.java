package com.javashitang;

import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * @author lilimin
 * @since 2021-03-20
 */
public class ErrorMessageDemo {

    public static void main(String[] args) {

        User user = new User();
        user.setName("小识");
        // 1. 选择errors实现
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 2. 调用reject或者rejectValue
        // 调用reject生成ObjectError
        // 调用rejectValue生成FieldError
        errors.reject("user.properties.not.null");
        errors.rejectValue("name", "name.required");

        // 3. 获取Errors中的ObjectError和FieldError
        List<ObjectError> allErrors = errors.getAllErrors();
        List<ObjectError> globalErrors = errors.getGlobalErrors();

        MessageSource messageSource = createMessageSource();

        for (ObjectError error : allErrors) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    public static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "user所有属性不能为空");
        messageSource.addMessage("id.required", Locale.getDefault(), "id is not null");
        messageSource.addMessage("name.required", Locale.getDefault(), "name is not null");
        return messageSource;
    }
}
