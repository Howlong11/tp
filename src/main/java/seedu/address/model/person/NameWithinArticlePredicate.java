package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.article.Article;

/**
 * Tests that a {@code Person}'s {@code Name} is within the {@code Article}.
 */
public class NameWithinArticlePredicate implements Predicate<Person> {
    private final Article article;

    /**
     * Constructs a {@code NameWithinArticlePredicate}.
     *
     * @param article The article to test against.
     */
    public NameWithinArticlePredicate(Article article) {
        this.article = article;
    }

    @Override
    public boolean test(Person person) {
        /*return article.getAuthors().stream()
                .anyMatch(author -> person.getName().fullName.equals(author.authorName)) ||
                article.getSources().stream()
                .anyMatch(source -> person.getName().fullName.equals(source.sourceName));*/
        return article.getPersons().contains(person);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NameWithinArticlePredicate)) {
            return false;
        }

        NameWithinArticlePredicate otherNameWithinArticlePredicate = (NameWithinArticlePredicate) other;
        return article.equals(otherNameWithinArticlePredicate.article);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("article", article).toString();
    }
}
