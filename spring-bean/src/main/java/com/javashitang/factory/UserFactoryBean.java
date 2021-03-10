package com.javashitang.factory;

import com.javashitang.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lilimin
 * @since 2021-03-10
 */
public class UserFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
