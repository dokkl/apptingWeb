package com.hoon.appting.repository.entity;

import com.mysema.query.types.expr.BooleanExpression;

public class UserPredicates {

	public static BooleanExpression nameLike(final String searchTerm) {
		return QUser.user.name.contains(searchTerm);
	}
	
	public static BooleanExpression findMatchUsers(final Long userManagerId) {
		return QUser.user.userManager.id.eq(userManagerId);
	}
}
