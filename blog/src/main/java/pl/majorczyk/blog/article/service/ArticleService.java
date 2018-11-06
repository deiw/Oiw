package pl.majorczyk.blog.article.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.majorczyk.blog.article.creator.ArticleCreator;
import pl.majorczyk.blog.article.exception.ArticleNotFoundException;
import pl.majorczyk.blog.article.model.Article;
import pl.majorczyk.blog.article.model.RawArticle;
import pl.majorczyk.blog.article.repository.ArticleRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleCreator articleCreator;

    public Article saveArticle(RawArticle rawArticle) {
        Article article = articleCreator.createArticle(rawArticle);
        return articleRepository.save(article);
    }

    public List<Article> getArticles() {
        return articleRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Article::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Article getArticleByTitle(String title) {
        return articleRepository.findByTitle(title)
                .orElseThrow(ArticleNotFoundException::new);
    }
}
