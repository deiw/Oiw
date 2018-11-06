package pl.majorczyk.blog.article.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.majorczyk.blog.article.model.Article;
import pl.majorczyk.blog.article.model.RawArticle;
import pl.majorczyk.blog.article.service.ArticleService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public String getMainPage(Model model) {
        List<Article> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("/articleform")
    public String getArticleFormPage(Model model){
        model.addAttribute("rawArticle", new RawArticle());
        return "articleform";
    }

    @PostMapping("/article")
    public String addArticle(@Valid @ModelAttribute RawArticle rawArticle, BindingResult result) {
        if(result.hasErrors()){
            return "articleform";
        }
        articleService.saveArticle(rawArticle);
        return "redirect:/";
    }

    @GetMapping("article/{title}")
    public String getSpecificArticle(Model model, @PathVariable String title) {
        Article article = articleService.getArticleByTitle(title);
        model.addAttribute("article", article);
        return "detail";
    }
}
