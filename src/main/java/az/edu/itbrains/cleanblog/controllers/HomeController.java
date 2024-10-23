package az.edu.itbrains.cleanblog.controllers;


import az.edu.itbrains.cleanblog.dtos.about.AboutDto;
import az.edu.itbrains.cleanblog.dtos.contact.ContactSendDto;
import az.edu.itbrains.cleanblog.models.Article;
import az.edu.itbrains.cleanblog.services.AboutService;
import az.edu.itbrains.cleanblog.services.ArticleService;
import az.edu.itbrains.cleanblog.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HomeController {

    private final ArticleService articleService;
    private final AboutService aboutService;
    private final ContactService contactService;

    public HomeController(ArticleService articleService, AboutService aboutService, ContactService contactService) {
        this.articleService = articleService;
        this.aboutService = aboutService;
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String home(Model model){

        List<Article> articles = articleService.getHomeArticles();

        model.addAttribute("hello","Hello world.");
        model.addAttribute("articles", articles);
        return "index.html";
    }

    @GetMapping("/about")
    public String about(Model model){
        AboutDto aboutDto = aboutService.getAboutInfo();
        model.addAttribute("about",aboutDto);
        return "about.html";
    }



}
