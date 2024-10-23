package az.edu.itbrains.cleanblog.controllers.dashboard;


import az.edu.itbrains.cleanblog.dtos.category.CategoryCreateDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.cleanblog.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/category")
    public String index(Model model){
        List<CategoryDashboardDto> categoryDashboardDtoList = categoryService.getDashboardCategories();
        model.addAttribute("categories",categoryDashboardDtoList);
        return "/dashboard/category/index.html";
    }


    @GetMapping("/admin/category/create")
    public String create(){
        return "/dashboard/category/create.html";
    }

    @PostMapping("/admin/category/create")
    public String create(CategoryCreateDto categoryCreateDto){
        boolean createCategory = categoryService.createCategory(categoryCreateDto);
        return "redirect:/admin/category";
    }


    @GetMapping("/admin/category/edit/{id}")
    public String update(@PathVariable Long id, Model model){
        CategoryUpdateDto categoryUpdateDto = categoryService.getUpdateCategory(id);
        model.addAttribute("category",categoryUpdateDto);
        return "/dashboard/category/update.html";
    }


    @PostMapping("/admin/category/edit/{id}")
    public String update(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto){
        CategoryUpdateDto category = categoryService.updateCategory(id,categoryUpdateDto);
        return "redirect:/admin/category";
    }

}
