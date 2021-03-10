package com.javashitang.factory;

import com.javashitang.domain.User;

/**
 * @author lilimin
 * @since 2021-03-10
 */
public class UserFactory {

	public User createUser() {
		return User.createUser();
	}
}
