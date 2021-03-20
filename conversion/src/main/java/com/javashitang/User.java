package com.javashitang;

import lombok.Data;
import lombok.ToString;

import java.util.Properties;

/**
 * @author lilimin
 * @since 2021-03-20
 */
@Data
@ToString
public class User {

    private Long id;
    private String name;
    private Properties context;
    private String contextAsText;
}
