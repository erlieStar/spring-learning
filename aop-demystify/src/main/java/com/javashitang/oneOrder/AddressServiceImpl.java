package com.javashitang.oneOrder;

/**
 * @author lilimin
 * @since 2022-01-10
 */
public class AddressServiceImpl implements AddressService {

    @Override
    public String address() {
        System.out.println("target");
        return "address";
    }
}
