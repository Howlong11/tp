package seedu.address.model.article;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Article's title in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTitle(String)}
 */
public class Title implements Comparable<Title> {
    public static final String MESSAGE_CONSTRAINTS =
            "Titles should should not be blank or start with a whitespace character.";

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

    @Override
    public int compareTo(Title other) {
        return this.fullTitle.compareTo(other.fullTitle);
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
        return otherTitle.fullTitle.equals(this.fullTitle);
    }

    @Override
    public int hashCode() {
        return fullTitle.hashCode();
    }
}
