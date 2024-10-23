package az.edu.itbrains.cleanblog.services;

import az.edu.itbrains.cleanblog.dtos.article.ArticleCreateDto;
import az.edu.itbrains.cleanblog.dtos.article.ArticleDashboardDto;
import az.edu.itbrains.cleanblog.dtos.article.ArticleDetailDto;
import az.edu.itbrains.cleanblog.dtos.article.ArticleHomeDto;
import az.edu.itbrains.cleanblog.models.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getHomeArticles();
    ArticleDetailDto getDetail(Long id);
    List<ArticleDashboardDto> getDashboardArticles();
    void createArticle(ArticleCreateDto articleCreateDto);
}
