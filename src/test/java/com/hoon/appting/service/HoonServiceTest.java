package com.hoon.appting.service;

import com.hoon.appting.repository.UserRepository;
import com.hoon.appting.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

/**
 * Created by hoon on 2014-09-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class HoonServiceTest {
    @InjectMocks
    private HoonService hoonService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void findShipment_가_정상적으로_동작한다() {
        @SuppressWarnings("unchecked")
        Page<User> requestedPage = mock(Page.class);
        Mockito.when(userRepository.findByUserManagerId(any(Long.class), any(Pageable.class))).thenReturn(requestedPage);
        Long id = 1L;
        hoonService.findShipmentById(id);


    }
}
