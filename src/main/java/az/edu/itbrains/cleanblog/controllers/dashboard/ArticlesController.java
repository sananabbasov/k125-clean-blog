package az.edu.itbrains.cleanblog.controllers.dashboard;


import az.edu.itbrains.cleanblog.dtos.article.ArticleCreateDto;
import az.edu.itbrains.cleanblog.dtos.article.ArticleDashboardDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryArticleDto;
import az.edu.itbrains.cleanblog.dtos.contact.ContactSendDto;
import az.edu.itbrains.cleanblog.services.ArticleService;
import az.edu.itbrains.cleanblog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticlesController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public ArticlesController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/article")
    public String index(Model model){

        List<ArticleDashboardDto> articleDashboardDtoList = articleService.getDashboardArticles();
        model.addAttribute("articles",articleDashboardDtoList);
        return "/dashboard/article/index.html";
    }


    @GetMapping("/admin/article/create")
    public String create(Model model){
        model.addAttribute("articleCreateDto", new ArticleCreateDto());
        List<CategoryArticleDto> categories = categoryService.getArticleCategories();
        model.addAttribute("categories", categories);
        return "/dashboard/article/create.html";
    }


    @PostMapping("/admin/article/create")
    public String create(@Valid ArticleCreateDto articleCreateDto, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            List<CategoryArticleDto> categories = categoryService.getArticleCategories();
            model.addAttribute("categories", categories);
            return "/dashboard/article/create.html";
        }

        articleService.createArticle(articleCreateDto);
        return "redirect:/admin/article";
    }


}
