package seedu.weeblingo.logic.parser;

import static seedu.weeblingo.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.HashSet;
import java.util.Set;

import seedu.weeblingo.logic.commands.StartCommand;
import seedu.weeblingo.logic.parser.exceptions.ParseException;
import seedu.weeblingo.model.tag.Tag;

public class StartCommandParser implements Parser<StartCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of StartCommand and returns the StartCommand
     * object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public StartCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        System.out.println(trimmedArgs);
        int numberOfQuestions = 0;
        Set<Tag> tagsSet = new HashSet<>();
        if (trimmedArgs.contains(" ")) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, StartCommand.MESSAGE_USAGE));
        }
        if (!trimmedArgs.isEmpty()) {
            try {
                numberOfQuestions = Integer.parseInt(args.replaceAll("\\s+", ""));
            } catch (NumberFormatException e) {
                String[] tags = args.strip().split(" ");
                try {
                    for (String tag : tags) {
                        tagsSet.add(new Tag(tag));
                    }
                } catch (IllegalArgumentException exception) {
                    throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
                }
            }
            if (numberOfQuestions > 0) {
                return new StartCommand(numberOfQuestions);
            } else if (!tagsSet.isEmpty()) {
                return new StartCommand(tagsSet);
            } else {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, StartCommand.MESSAGE_USAGE));
            }
        }
        return new StartCommand();
    }
}
