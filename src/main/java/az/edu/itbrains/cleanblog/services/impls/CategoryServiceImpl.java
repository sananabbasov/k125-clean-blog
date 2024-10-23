package az.edu.itbrains.cleanblog.services.impls;

import az.edu.itbrains.cleanblog.dtos.category.CategoryArticleDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryCreateDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.cleanblog.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.cleanblog.models.Category;
import az.edu.itbrains.cleanblog.repositories.CategoryRepository;
import az.edu.itbrains.cleanblog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDashboardDto> getDashboardCategories() {
        List<Category> getAllCategories = categoryRepository.findAll();
        List<CategoryDashboardDto> categoryDashboardDtoList = new ArrayList<>();

        for (Category category: getAllCategories) {
            CategoryDashboardDto categoryDashboardDto = new CategoryDashboardDto();
            categoryDashboardDto.setId(category.getId());
            categoryDashboardDto.setName(category.getName());
            long count = category.getArticles().stream().count();
            categoryDashboardDto.setArticleCount(count);
            categoryDashboardDtoList.add(categoryDashboardDto);
        }

        return categoryDashboardDtoList;
    }

    @Override
    public boolean createCategory(CategoryCreateDto categoryCreateDto) {
        Category findCategory = categoryRepository.findByName(categoryCreateDto.getName());
        if (findCategory != null){
            return false;
        }
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
        return true;
    }

    @Override
    public CategoryUpdateDto getUpdateCategory(Long id) {
        Category findCategory = categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto categoryUpdateDto = new CategoryUpdateDto(findCategory.getName());
        return categoryUpdateDto;
    }

    @Override
    public CategoryUpdateDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category findCategory = categoryRepository.findById(id).orElseThrow();
        findCategory.setName(categoryUpdateDto.getName());
        categoryRepository.save(findCategory);
        return categoryUpdateDto;
    }

    @Override
    public List<CategoryArticleDto> getArticleCategories() {
        List<Category> findCategories = categoryRepository.findAll();
        List<CategoryArticleDto> categories = findCategories.stream().map(cat -> modelMapper.map(cat, CategoryArticleDto.class)).collect(Collectors.toList());
        return categories;
    }

    @Override
    public Category findCategory(Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).orElseThrow();
            return category;
        }catch (Exception e){
            return null;
        }
    }


}
