package ua.kpi.coursework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kpi.coursework.domain.User;

@Controller
public class AppController {

    @ModelAttribute("user")
    public User emptyUserModel(){
        return new User();
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }


    @GetMapping("/admin")
    public String adminIndex(){
        return "admin_index";
    }

}
