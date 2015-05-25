package com.hoon.appting.controller;

import com.hoon.appting.repository.UserManagerRepository;
import com.hoon.appting.repository.entity.User;
import com.hoon.appting.repository.entity.UserManager;
import com.hoon.appting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserManagerRepository userManagerRepository;

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String main(Model model) {
        System.out.println("sss mainController");
        //List<User> list = userService.findByUserManagerId(0L, 0, 5);
        User user = new User();
        user.setEmail("jordan@nba.com");
        user.setName("jordan");

        UserManager userManager = userManagerRepository.findOne(1L);
        user.setUserManager(userManager);
        userService.save(user);

        List<User> list = userService.findByName("jordan");
        for (User user1 : list) {
            System.out.println("user1 name : " + user1.getName());
            if (user1.getUserManager() != null) {
                System.out.println("user1 mapanger name : " + user1.getUserManager().getName());
            }

        }

        System.out.println("sss list size : " + list.size());
        return "index";
    }
}
