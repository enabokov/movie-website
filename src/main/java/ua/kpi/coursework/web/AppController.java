package ua.kpi.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.coursework.domain.Movie;
import ua.kpi.coursework.domain.User;
import ua.kpi.coursework.service.MovieServiceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @GetMapping("/genre/{genre}")
    public String movieByGenrePage(Model model, @PathVariable String genre, @RequestParam(required = false) Integer page) {
        int limit = 5;  // how many movies displayed per page

        if (page == null)
            page = 0;

        model.addAttribute("genre", genre);
        model.addAttribute("genres", movieService.getUniqueGenres());
        model.addAttribute("totalMovies", movieService.getTotalByGenre(genre));
        model.addAttribute("moviesByGenre", movieService.getMoviesByGenre(genre, new PageRequest(page, limit)));

        return "moviesByGenre";
    }

    @GetMapping(value = "/")
    public String indexPage(Model model, @RequestParam(required = false) Integer page) {
        int limit = 3;  // how many movies displayed per page

        if (page == null)
            page = 0;

        int year = Calendar.getInstance().get(Calendar.YEAR);
        model.addAttribute("genres", movieService.getUniqueGenres());
        model.addAttribute("totalMovies", Math.ceil(movieService.getTotalByYear(year) / limit));
        model.addAttribute("moviesByYear", movieService.getMoviesByYear(year, new PageRequest(page, limit)));

        return "index";
    }



    @GetMapping("/admin")
    public String adminIndex(){
        return "admin_index";
    }

}
