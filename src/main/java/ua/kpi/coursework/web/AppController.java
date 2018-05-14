package ua.kpi.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.kpi.coursework.domain.User;
import ua.kpi.coursework.service.MovieServiceImpl;

import java.util.Calendar;

@Controller
public class AppController {

    @Autowired
    private MovieServiceImpl movieService;

    @ModelAttribute("user")
    public User emptyUserModel(){
        return new User();
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/")
    public String indexPage(Model model) throws Exception {
        model.addAttribute("moviesByYear", movieService.getByYear(Calendar.getInstance().get(Calendar.YEAR)));
        return "index";
    }

    @GetMapping("/admin")
    public String adminIndex(){
        return "admin_index";
    }

}
