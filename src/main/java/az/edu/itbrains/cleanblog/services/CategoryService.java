package az.edu.itbrains.cleanblog.services;

import az.edu.itbrains.cleanblog.dtos.category.CategoryArticleDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryCreateDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.cleanblog.models.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDashboardDto> getDashboardCategories();
    boolean createCategory(CategoryCreateDto categoryCreateDto);
    CategoryUpdateDto getUpdateCategory(Long id);
    CategoryUpdateDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);
    List<CategoryArticleDto> getArticleCategories();
    Category findCategory(Long categoryId);
}
