package com.javashitang.proxy;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class DefaultEchoService implements EchoService {

    @Override
    public String echo(String message) {
        return message;
    }
}
