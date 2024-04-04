package seedu.address.testutil;

import seedu.address.model.ArticleBook;
import seedu.address.model.article.Article;

/**
 * A utility class to help with building ArticleBook objects.
 * Example usage: <br>
 *     {@code ArticleBook ab = new ArticleBookBuilder().withArticle("NVIDIA", "INTEL").build();}
 */
public class ArticleBookBuilder {

    private ArticleBook articleBook;

    public ArticleBookBuilder() {
        articleBook = new ArticleBook();
    }

    public ArticleBookBuilder(ArticleBook articleBook) {
        this.articleBook = articleBook;
    }

    /**
     * Adds a new {@code Article} to the {@code ArticleBook} that we are building.
     */
    public ArticleBookBuilder withArticle(Article article) {
        articleBook.addArticle(article);
        return this;
    }

    public ArticleBook build() {
        return articleBook;
    }
}
