package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;

import java.util.ArrayList;

import seedu.address.logic.commands.articlecommands.SortArticleCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortArticleCommand object
 */
public class SortArticleCommandParser implements Parser<SortArticleCommand> {

    private static final ArrayList<String> AllowedPrefixes = new ArrayList<>() {
        {
            add(PREFIX_DATE.getPrefix());
        }
    };

    /**
     * Checks if the given prefix is allowed in choosing an attribute for sorting that is case-insensitive.
     */
    public static boolean isAllowedPrefix(String prefix) {
        return AllowedPrefixes.contains(prefix.toLowerCase()) || AllowedPrefixes.contains(prefix.toUpperCase());
    }

    /**
     * Parses the given {@code String} of arguments in the context of the SortArticleCommand
     * and returns an SortArticleCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortArticleCommand parse(String args) throws ParseException {
        String prefix = args.trim();
        if (prefix.isEmpty() || !PREFIX_DATE.getPrefix().equalsIgnoreCase(prefix)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortArticleCommand.MESSAGE_USAGE));
        }

        return new SortArticleCommand(prefix);
    }
}
