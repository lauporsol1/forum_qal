package com.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.User;
import com.user.UserRepository;
import com.user.UserService;

@Controller
public class AppController {
 
    @Autowired
    private UserService userService;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userService.save(user);
         
        return "register_success";
    }
    
    @GetMapping("/index")
    public String viewHomePageAuthenticated() {
        return "index_authenticated";
    }
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.getUser();
        model.addAttribute("listUsers", listUsers);
         
        return "users";
    }
    
}
