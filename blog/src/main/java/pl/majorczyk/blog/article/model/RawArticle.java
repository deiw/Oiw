package pl.majorczyk.blog.article.model;

import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class RawArticle {

   // @NotEmpty(message = "Field cannot be empty")
    private String title;
   // @NotEmpty(message = "Field cannot be empty")
    private String content;
}
