package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.LookupCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new LookupCommand object
 */
public class LookupCommandParser implements Parser<LookupCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the LookupCommand
     * and returns a LookupCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public LookupCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new LookupCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, LookupCommand.MESSAGE_USAGE), pe);
        }
    }

}
