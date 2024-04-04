package seedu.address.testutil;

import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.FIRST_VALID_AUTHOR_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.FIRST_VALID_AUTHOR_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.FIRST_VALID_SOURCE_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.FIRST_VALID_SOURCE_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.FIRST_VALID_TAG_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.FIRST_VALID_TAG_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.SECOND_VALID_AUTHOR_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.SECOND_VALID_AUTHOR_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.SECOND_VALID_SOURCE_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.SECOND_VALID_SOURCE_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.SECOND_VALID_TAG_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.SECOND_VALID_TAG_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_LINK_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_LINK_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_PUBLICATION_DATE_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_PUBLICATION_DATE_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_STATUS_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_STATUS_NVIDIA;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_TITLE_INTEL;
import static seedu.address.logic.commands.articlecommands.ArticleCommandTestUtil.VALID_TITLE_NVIDIA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import seedu.address.model.ArticleBook;
import seedu.address.model.article.Article;

/**
 * A utility class containing a list of {@code Article} objects to be used in tests.
 */
public class TypicalArticles {

    public static final Article ONCE = new ArticleBuilder().withTitle("Once upon a time")
            .withAuthors("Barney Loo", "Booney Loo")
            .withPublicationDate("03-01-2021")
            .withSources("Domo Dragto")
            .withOutlets("Okto News Outlet")
            .withTags("Fantasy")
            .withStatus("DRAFT")
            .withLink("https://www.google.com/").build();
    public static final Article TWICE = new ArticleBuilder().withTitle("Twice upon a time")
            .withAuthors("Carney Loo", "Dooney Loo")
            .withPublicationDate("04-02-2021")
            .withSources("Barny Dragto", "Domo Dragto")
            .withOutlets("Okto News Outlet")
            .withTags("Autobiography")
            .withStatus("DRAFT")
            .withLink("https://www.google.com/").build();
    public static final Article THRICE = new ArticleBuilder().withTitle("Thrice upon a time")
            .withAuthors("Earney Loo", "Fooney Loo")
            .withPublicationDate("05-03-2021")
            .withSources("Carny Dragto", "Midi Dragto")
            .withOutlets("Okto News Outlet")
            .withTags("Relatable", "Meme")
            .withStatus("PUBLISHED")
            .withLink("https://www.google.com/").build();
    public static final Article FOUR = new ArticleBuilder().withTitle("Four upon a time")
            .withAuthors("Garny Loo", "Hooney Loo")
            .withPublicationDate("06-04-2021")
            .withSources("Darny Dragto", "Domo Dragto")
            .withOutlets("Okto News Outlet")
            .withTags("Fiction")
            .withStatus("ARCHIVED")
            .withLink("https://www.google.com/").build();
    public static final Article FIVE = new ArticleBuilder().withTitle("Five upon a time")
            .withAuthors("Iarny Loo", "Jooney Loo")
            .withPublicationDate("07-05-2021")
            .withSources("Earny Dragto", "Midi Dragto")
            .withOutlets("Okto News Outlet")
            .withTags("Non-Fiction")
            .withStatus("DRAFT")
            .withLink("https://www.google.com/").build();
    public static final Article SIX = new ArticleBuilder().withTitle("Six upon a time")
            .withAuthors("Karny Loo", "Looney Loo")
            .withPublicationDate("08-06-2021")
            .withSources("Farny Dragto", "Foof Dragto")
            .withOutlets("Okto News Outlet")
            .withTags("Science")
            .withStatus("PUBLISHED")
            .withLink("https://www.google.com/").build();

    // Manually added - Article's details found in {@code ArticleCommandTestUtil}
    public static final Article NVIDIA = new ArticleBuilder().withTitle(VALID_TITLE_NVIDIA)
            .withAuthors(FIRST_VALID_AUTHOR_NVIDIA, SECOND_VALID_AUTHOR_NVIDIA)
            .withPublicationDate(VALID_PUBLICATION_DATE_NVIDIA)
            .withSources(FIRST_VALID_SOURCE_NVIDIA, SECOND_VALID_SOURCE_NVIDIA)
            .withOutlets("Okto News Outlet")
            .withTags(FIRST_VALID_TAG_NVIDIA, SECOND_VALID_TAG_NVIDIA)
            .withStatus(VALID_STATUS_NVIDIA)
            .withLink(VALID_LINK_NVIDIA).build();

    public static final Article INTEL = new ArticleBuilder().withTitle(VALID_TITLE_INTEL)
            .withAuthors(FIRST_VALID_AUTHOR_INTEL, SECOND_VALID_AUTHOR_INTEL)
            .withPublicationDate(VALID_PUBLICATION_DATE_INTEL)
            .withSources(FIRST_VALID_SOURCE_INTEL, SECOND_VALID_SOURCE_INTEL)
            .withOutlets("Okto News Outlet")
            .withTags(FIRST_VALID_TAG_INTEL, SECOND_VALID_TAG_INTEL)
            .withStatus(VALID_STATUS_INTEL)
            .withLink(VALID_LINK_INTEL).build();

    private TypicalArticles() {} // prevents instantiation

    /**
     * Returns an {@code ArticleBook} with all the typical articles.
     */
    public static ArticleBook getTypicalArticleBook() {
        ArticleBook ab = new ArticleBook();
        for (Article article : getTypicalArticles()) {
            ab.addArticle(article);
        }
        return ab;
    }

    /**
     * Returns an {@code ArticleBook} with all the typical articles in reversed order.
     */
    public static ArticleBook getTypicalReversedArticleBook() {
        ArticleBook ab = new ArticleBook();
        List<Article> reversedListOfArticles = getTypicalArticles();
        Collections.reverse(reversedListOfArticles);
        for (Article article : reversedListOfArticles) {
            ab.addArticle(article);
        }
        return ab;
    }

    public static List<Article> getTypicalArticles() {
        return new ArrayList<>(Arrays.asList(ONCE, TWICE, THRICE, FOUR, FIVE, SIX));
    }
}
