package seedu.address.model.article;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Article's title in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTitle(String)}
 */
public class Title {
    public static final String MESSAGE_CONSTRAINTS =
            "Headlines should should not be blank or start with a whitespace character.";

    public static final String VALIDATION_REGEX = "^(?!\\s).*";

    public final String fullTitle;

    /**
     * Constructs a {@code Title}.
     *
     * @param title A valid title.
     */
    public Title(String title) {
        requireNonNull(title);
        checkArgument(isValidTitle(title), MESSAGE_CONSTRAINTS);
        fullTitle = title;
    }

    /**
     * Returns true if a given string is a valid title.
     */
    public static boolean isValidTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullTitle;
    }

    private boolean areSameTitles(String[] title, String[] otherTitle) {
        if (title.length != otherTitle.length) {
            return false;
        }
        for (int i = 0; i < title.length; i++) {
            if (!title[i].equalsIgnoreCase(otherTitle[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Title)) {
            return false;
        }

        Title otherTitle = (Title) other;
        String[] splitTitle = fullTitle.split("\\s+");
        String[] splitOtherTitle = otherTitle.fullTitle.split("\\s+");

        return areSameTitles(splitTitle, splitOtherTitle);
    }

    // It is safe to implement hashCode() this way because there are already precautions
    // in place to ensure that no two Title instances can be kept in articles in the Article Book
    // that are equal and yet have different hashcode values.
    @Override
    public int hashCode() {
        return fullTitle.hashCode();
    }
}
