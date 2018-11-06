package pl.majorczyk.blog.article.creator;

import org.springframework.stereotype.Service;
import pl.majorczyk.blog.article.model.Article;
import pl.majorczyk.blog.article.model.RawArticle;

import java.time.OffsetDateTime;

@Service
public class ArticleCreator {

    public Article createArticle(RawArticle rawArticle) {
        return Article.builder()
                .title(rawArticle.getTitle())
                .content(rawArticle.getContent())
                .date(OffsetDateTime.now())
                .build();
    }
}
