package az.edu.itbrains.cleanblog.services.impls;

import az.edu.itbrains.cleanblog.dtos.article.ArticleCreateDto;
import az.edu.itbrains.cleanblog.dtos.article.ArticleDashboardDto;
import az.edu.itbrains.cleanblog.dtos.article.ArticleDetailDto;
import az.edu.itbrains.cleanblog.models.Article;
import az.edu.itbrains.cleanblog.models.Category;
import az.edu.itbrains.cleanblog.repositories.ArticleRepository;
import az.edu.itbrains.cleanblog.services.ArticleService;
import az.edu.itbrains.cleanblog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Article> getHomeArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    @Override
    public ArticleDetailDto getDetail(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        ArticleDetailDto articleDetail = new ArticleDetailDto();
        articleDetail.setId(article.getId());
        articleDetail.setTitle(article.getTitle());
        articleDetail.setDescription(article.getDescription());
        return articleDetail;
    }

    @Override
    public List<ArticleDashboardDto> getDashboardArticles() {
        List<Article> findArticles = articleRepository.findAll();
        List<ArticleDashboardDto> articles = findArticles.stream().map(article -> modelMapper.map(article,ArticleDashboardDto.class)).collect(Collectors.toList());
        return articles;
    }

    @Override
    public void createArticle(ArticleCreateDto articleCreateDto) {
        Category findCategory = categoryService.findCategory(articleCreateDto.getCategoryId());
        Article article = modelMapper.map(articleCreateDto,Article.class);
        article.setCategory(findCategory);
        article.setDescription(articleCreateDto.getEditor1());
        articleRepository.save(article);
    }
}
