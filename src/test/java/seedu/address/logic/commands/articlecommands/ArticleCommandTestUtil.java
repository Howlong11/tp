package seedu.address.logic.commands.articlecommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONTRIBUTOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INTERVIEWEE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LINK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_OUTLET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ArticleBook;
import seedu.address.model.Model;
import seedu.address.model.article.Article;
import seedu.address.model.article.TitleContainsKeywordsPredicate;
import seedu.address.testutil.EditArticleDescriptorBuilder;

/**
 * Contains helper methods for testing article commands.
 */
public class ArticleCommandTestUtil {

    public static final String VALID_TITLE_NVIDIA = "Nvidia's new B200 'Blackwell' chips change the game";
    public static final String VALID_TITLE_INTEL = "Intel's new 12th Gen Alder Lake CPUs makes gaming so much better";
    public static final String FIRST_VALID_AUTHOR_NVIDIA = "Alice Wang";
    public static final String SECOND_VALID_AUTHOR_NVIDIA = "Amy Wong";
    public static final String FIRST_VALID_AUTHOR_INTEL = "Bob Ross";
    public static final String SECOND_VALID_AUTHOR_INTEL = "Bobby Fisher";
    public static final String VALID_PUBLICATION_DATE_NVIDIA = "20-03-2024 12:00";
    public static final String VALID_PUBLICATION_DATE_INTEL = "22-04-2022 20:00";
    public static final String FIRST_VALID_SOURCE_NVIDIA = "Jensen Huang";
    public static final String SECOND_VALID_SOURCE_NVIDIA = "Morris Chang";
    public static final String FIRST_VALID_SOURCE_INTEL = "Patrick Gelsinger";
    public static final String SECOND_VALID_SOURCE_INTEL = "Greg Lavender";
    public static final String FIRST_VALID_OUTLET_NVIDIA = "BBC News";
    public static final String SECOND_VALID_OUTLET_NVIDIA = "The Economic Times";
    public static final String FIRST_VALID_OUTLET_INTEL = "CNBC News";
    public static final String SECOND_VALID_OUTLET_INTEL = "The New York Times";
    public static final String FIRST_VALID_TAG_NVIDIA = "R&D";
    public static final String SECOND_VALID_TAG_NVIDIA = "Tech";
    public static final String FIRST_VALID_TAG_INTEL = "Gaming";
    public static final String SECOND_VALID_TAG_INTEL = "Tech";
    public static final String VALID_STATUS_NVIDIA = "PUBLISHED";
    public static final String VALID_STATUS_INTEL = "ARCHIVED";
    public static final String VALID_LINK_NVIDIA = "https://www.nvidia.com/en-sg/";
    public static final String VALID_LINK_INTEL = "https://www.intel.com/content/www/us/en/homepage.html";

    public static final String TITLE_DESC_NVIDIA = " " + PREFIX_HEADLINE + VALID_TITLE_NVIDIA;
    public static final String TITLE_DESC_INTEL = " " + PREFIX_HEADLINE + VALID_TITLE_INTEL;
    public static final String AUTHOR_DESC_NVIDIA = " " + PREFIX_CONTRIBUTOR + FIRST_VALID_AUTHOR_NVIDIA
            + " " + PREFIX_CONTRIBUTOR + SECOND_VALID_AUTHOR_NVIDIA;
    public static final String AUTHOR_DESC_INTEL = " " + PREFIX_CONTRIBUTOR + FIRST_VALID_AUTHOR_INTEL
            + " " + PREFIX_CONTRIBUTOR + SECOND_VALID_AUTHOR_INTEL;
    public static final String PUBLICATION_DATE_DESC_NVIDIA = " " + PREFIX_DATE
            + VALID_PUBLICATION_DATE_NVIDIA;
    public static final String PUBLICATION_DATE_DESC_INTEL = " " + PREFIX_DATE
            + VALID_PUBLICATION_DATE_INTEL;
    public static final String SOURCE_DESC_NVIDIA = " " + PREFIX_INTERVIEWEE + FIRST_VALID_SOURCE_NVIDIA
            + " " + PREFIX_INTERVIEWEE + SECOND_VALID_SOURCE_NVIDIA;
    public static final String SOURCE_DESC_INTEL = " " + PREFIX_INTERVIEWEE + FIRST_VALID_SOURCE_INTEL
            + " " + PREFIX_INTERVIEWEE + SECOND_VALID_SOURCE_INTEL;
    public static final String OUTLET_DESC_NVIDIA = " " + PREFIX_OUTLET + FIRST_VALID_OUTLET_NVIDIA
            + " " + PREFIX_OUTLET + SECOND_VALID_OUTLET_NVIDIA;
    public static final String OUTLET_DESC_INTEL = " " + PREFIX_OUTLET + FIRST_VALID_OUTLET_INTEL
            + " " + PREFIX_OUTLET + SECOND_VALID_OUTLET_INTEL;
    public static final String TAG_DESC_NVIDIA = " " + PREFIX_TAG + FIRST_VALID_TAG_NVIDIA
            + " " + PREFIX_TAG + SECOND_VALID_TAG_NVIDIA;
    public static final String TAG_DESC_INTEL = " " + PREFIX_TAG + FIRST_VALID_TAG_INTEL
            + " " + PREFIX_TAG + SECOND_VALID_TAG_INTEL;
    public static final String STATUS_DESC_NVIDIA = " " + PREFIX_STATUS + VALID_STATUS_NVIDIA;
    public static final String STATUS_DESC_INTEL = " " + PREFIX_STATUS + VALID_STATUS_INTEL;
    public static final String LINK_DESC_NVIDIA = " " + PREFIX_LINK + VALID_LINK_NVIDIA;
    public static final String LINK_DESC_INTEL = " " + PREFIX_LINK + VALID_LINK_INTEL;

    public static final String INVALID_TITLE_DESC = " " + PREFIX_HEADLINE; // empty string not allowed for titles
    public static final String INVALID_AUTHOR_DESC = " " + PREFIX_CONTRIBUTOR + "Bob&"; // '&' not allowed in authors
    public static final String INVALID_PUBLICATION_DATE_DESC = " " + PREFIX_DATE
            + "03-20-2024 12:00"; // Invalid date format
    public static final String INVALID_PUBLICATION_TIME_DESC = " " + PREFIX_DATE
            + "20-03-2024 25:00"; // Invalid time format
    public static final String INVALID_SOURCE_DESC = " " + PREFIX_INTERVIEWEE + "Ryan&"; // '&' not allowed in sources
    public static final String INVALID_OUTLET_DESC = " " + PREFIX_OUTLET + "BBC News*"; // '*' not allowed in outlets
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "Tech*"; // '*' not allowed in tags
    public static final String INVALID_STATUS_DESC = " " + PREFIX_STATUS + "PUBLISHEDD"; // Invalid status

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditArticleCommand.EditArticleDescriptor DESC_NVIDIA;
    public static final EditArticleCommand.EditArticleDescriptor DESC_INTEL;

    static {
        DESC_NVIDIA = new EditArticleDescriptorBuilder().withTitle(VALID_TITLE_NVIDIA)
                .withAuthors(FIRST_VALID_AUTHOR_NVIDIA, SECOND_VALID_AUTHOR_NVIDIA)
                .withPublicationDate(VALID_PUBLICATION_DATE_NVIDIA)
                .withSources(FIRST_VALID_SOURCE_NVIDIA, SECOND_VALID_SOURCE_NVIDIA)
                .withOutlets(FIRST_VALID_OUTLET_NVIDIA, SECOND_VALID_OUTLET_NVIDIA)
                .withTags(FIRST_VALID_TAG_NVIDIA, SECOND_VALID_TAG_NVIDIA)
                .withStatus(VALID_STATUS_NVIDIA)
                .withLink(VALID_LINK_NVIDIA).build();
        DESC_INTEL = new EditArticleDescriptorBuilder().withTitle(VALID_TITLE_INTEL)
                .withAuthors(FIRST_VALID_AUTHOR_INTEL, SECOND_VALID_AUTHOR_INTEL)
                .withPublicationDate(VALID_PUBLICATION_DATE_INTEL)
                .withSources(FIRST_VALID_SOURCE_INTEL, SECOND_VALID_SOURCE_INTEL)
                .withOutlets(FIRST_VALID_OUTLET_INTEL, SECOND_VALID_OUTLET_INTEL)
                .withTags(FIRST_VALID_TAG_INTEL, SECOND_VALID_TAG_INTEL)
                .withStatus(VALID_STATUS_INTEL)
                .withLink(VALID_LINK_INTEL).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(ArticleCommand command, Model actualModel,
                                            CommandResult expectedCommandResult, Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(ArticleCommand, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(ArticleCommand command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the article book, filtered article list and selected article in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(ArticleCommand command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        ArticleBook expectedArticleBook = new ArticleBook(actualModel.getArticleBook());
        List<Article> expectedFilteredList = new ArrayList<>(actualModel.getFilteredArticleList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedArticleBook, actualModel.getArticleBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredArticleList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the article at the given {@code targetIndex} in the
     * {@code model}'s article book.
     */
    public static void showArticleAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredArticleList().size());

        Article article = model.getFilteredArticleList().get(targetIndex.getZeroBased());
        final String[] splitTitle = article.getTitle().fullTitle.split("\\s+");
        model.updateFilteredArticleList(new TitleContainsKeywordsPredicate(Arrays.asList(splitTitle[0])));

        assertEquals(1, model.getFilteredArticleList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the articles within the range {@code startIndex-endIndex}
     * in the {@code model}'s article book.
     */
    public static void showArticleInRange(Model model, Index startIndex, Index endIndex) {
        assertTrue(0 <= startIndex.getZeroBased());
        assertTrue(startIndex.getZeroBased() < model.getFilteredArticleList().size());
        assertTrue(endIndex.getZeroBased() < model.getFilteredArticleList().size());
        assertTrue(startIndex.getZeroBased() <= endIndex.getZeroBased());

        ArrayList<String> articleFirstTitleWords = new ArrayList<>();

        for (int i = startIndex.getZeroBased(); i <= endIndex.getZeroBased(); i++) {
            Article article = model.getFilteredArticleList().get(i);
            final String[] splitTitle = article.getTitle().fullTitle.split("\\s+");
            articleFirstTitleWords.add(splitTitle[0]);
        }

        model.updateFilteredArticleList(new TitleContainsKeywordsPredicate(articleFirstTitleWords));

        assertEquals(endIndex.getOneBased() - startIndex.getZeroBased(), model.getFilteredArticleList().size());
    }
}
