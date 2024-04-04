package seedu.address.logic.commands.articlecommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.article.Article;

/**
 * Lookups an article identified using it's displayed index from the article book. //change?
 */
public class LookupArticleCommand extends ArticleCommand {

    public static final String COMMAND_WORD = "lookup";

    public static final String COMMAND_PREFIX = "-a";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + COMMAND_PREFIX
            + ": Lookups the article identified by the index number used in the displayed article list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " " + COMMAND_PREFIX + " 1";

    public static final String MESSAGE_LOOKUP_ARTICLE_SUCCESS = "Lookup Article: %1$s"; //change?v

    private final Index targetIndex;

    /**
     * Creates a LookupArticleCommand to lookup the article at the specified {@code Index}.
     *
     * @param targetIndex The index of the article to lookup.
     */
    public LookupArticleCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Article> lastShownList = model.getFilteredArticleList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ARTICLE_DISPLAYED_INDEX);
        }

        Article articleToLookup = lastShownList.get(targetIndex.getZeroBased());
        model.lookupArticle(articleToLookup);
        return new CommandResult(String.format(MESSAGE_LOOKUP_ARTICLE_SUCCESS, Messages.format(articleToLookup)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LookupArticleCommand)) {
            return false;
        }

        LookupArticleCommand otherLookupArticleCommand = (LookupArticleCommand) other;
        return targetIndex.equals(otherLookupArticleCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
