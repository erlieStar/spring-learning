package com.javashitang;

import org.springframework.context.MessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

import static com.javashitang.ErrorMessageDemo.createMessageSource;

/**
 * @author lilimin
 * @since 2021-03-10
 */
public class ValidatorDemo {


    public static void main(String[] args) {

        // 1. 创建Validator
        Validator validator = new UserValidator();
        User user = new User();

        // 2. 判断是否支持目标对象类型
        validator.supports(user.getClass());

        // 3. 创建Errors对象
        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);

        // 4. 获取MessageSource对象
        MessageSource messageSource = createMessageSource();

        // 5. 输出所有的错误文案
        for (ObjectError error : errors.getAllErrors()) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }
    }


    static class UserValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        }
    }
}
