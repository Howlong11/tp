package seedu.address.model.article;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Article's link in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidLink(String)}
 */
public class Link {
    public static final String MESSAGE_CONSTRAINTS =
            "Link cannot start with a whitespace character.";

    public static final String VALIDATION_REGEX = "^(?!\\s).*";

    public final String link;

    /**
     * Constructs a {@code Title}.
     *
     * @param link A valid title.
     */
    public Link(String link) {
        if (link == null) {
            link = "";
        }
        checkArgument(isValidLink(link), MESSAGE_CONSTRAINTS);
        this.link = link;
    }

    /**
     * Returns true if a given string is a valid link.
     */
    public static boolean isValidLink(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return link;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Link)) {
            return false;
        }

        Link otherTitle = (Link) other;
        return otherTitle.link.equals(this.link);
    }

    @Override
    public int hashCode() {
        return link.hashCode();
    }
}
