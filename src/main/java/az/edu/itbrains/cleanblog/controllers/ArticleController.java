package az.edu.itbrains.cleanblog.controllers;

import az.edu.itbrains.cleanblog.dtos.article.ArticleDetailDto;
import az.edu.itbrains.cleanblog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/article/detail/{id}")
    public String post(@PathVariable Long id, Model model){
        ArticleDetailDto articleDetail = articleService.getDetail(id);
        model.addAttribute("article", articleDetail);
        return "post.html";
    }
}
