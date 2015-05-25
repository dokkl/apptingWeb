package com.hoon.appting.controller;

import com.hoon.appting.util.AbstractRepositoryTestApplicationContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hoon on 2015-04-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AbstractRepositoryTestApplicationContextConfig.class)
public class FactoryControllerTest {


    FactoryController factoryController = new FactoryController();

    @Test
    public void getTypesTest() {
        List<String> types = factoryController.getTypes() ;
        for (String type : types) {
            System.out.println("type : " + type);
        }
    }

    /*@Test
    public void executeTrackingTest() {
        factoryController.executeTracking();
    }*/

}
