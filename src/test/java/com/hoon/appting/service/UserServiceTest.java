package com.hoon.appting.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.hoon.appting.repository.UserRepository;
import com.hoon.appting.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.collect.Lists;
import com.mysema.query.types.expr.BooleanExpression;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void findByUserManagerId() {
		@SuppressWarnings("unchecked")
		Page<User> requestedPage = mock(Page.class);
		
		when(userRepository.findByUserManagerId(any(Long.class), any(Pageable.class))).thenReturn(requestedPage);
		
		userService.findByUserManagerId(0L, 0, 5);
		
		verify(userRepository, times(1)).findByUserManagerId(any(Long.class), any(Pageable.class));
	}
	
	@Test
	public void findByName() {
		
		List<User> users = Lists.newArrayList();
		users.add(new User());
		
		when(userRepository.findAll(any(BooleanExpression.class))).thenReturn(users);
		
		userService.findByName("need4spd");
		
		verify(userRepository, times(1)).findAll(any(BooleanExpression.class));
	}
}
