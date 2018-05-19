package ua.kpi.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.kpi.coursework.domain.User;
import ua.kpi.coursework.service.MovieServiceImpl;
import ua.kpi.coursework.service.SecurityService;
import ua.kpi.coursework.service.UserService;
import ua.kpi.coursework.validator.UserValidator;

import java.util.Calendar;

@Controller
public class AppController {

    private final MovieServiceImpl movieService;
    private final UserValidator userValidator;
    private final UserService userService;
    private final SecurityService securityService;

    @Autowired
    public AppController(MovieServiceImpl movieService, UserValidator userValidator, UserService userService, SecurityService securityService) {
        this.movieService = movieService;
        this.userValidator = userValidator;
        this.userService = userService;
        this.securityService = securityService;
    }

    @ModelAttribute("user")
    public User emptyUserModel() {
        return new User();
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/genre/{genre}")
    public String movieByGenrePage(Model model, @PathVariable String genre, @RequestParam(required = false) Integer page) {
        int limit = 50;  // how many movies displayed per page
        int pages = 15;

        if (page == null)
            page = 0;

        int totalMovies = movieService.getTotalByGenre(genre);
        model.addAttribute("genre", genre);
        model.addAttribute("genres", movieService.getUniqueGenres());
        model.addAttribute("totalMovies", Math.ceil(totalMovies / limit) > pages ? pages : Math.ceil(totalMovies / limit));
        model.addAttribute("moviesByGenre", movieService.getMoviesByGenre(genre, new PageRequest(page, limit)));

        return "moviesByGenre";
    }

    @GetMapping(value = "/")
    public String indexPage(Model model, @RequestParam(required = false) Integer page) {
        int limit = 50;  // how many movies displayed per page

        if (page == null)
            page = 0;

        int year = Calendar.getInstance().get(Calendar.YEAR) - 1;
        model.addAttribute("genres", movieService.getUniqueGenres());
        model.addAttribute("totalMovies", Math.ceil(movieService.getTotalByYear(year) / limit));
        model.addAttribute("moviesByYear", movieService.getMoviesByYear(year, new PageRequest(page, limit)));

        return "index";
    }

    @GetMapping("/admin")
    public String adminIndex() {
        return "admin_index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getLogin(), userForm.getPasswordConfirm());

        return "redirect:/";
    }
}
