package seedu.address.model.article;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Tests that an {@code Article} is within a {@code Person}'s list of articles.
 */
public class ArticleWithinPersonPredicate implements Predicate<Article> {

    private final Person person;

    /**
     * Constructs a {@code ArticleWithinPersonPredicate}.
     *
     * @param person The person to test against.
     */
    public ArticleWithinPersonPredicate(Person person) {
        this.person = person;
    }

    @Override
    public boolean test(Article article) {
        return person.getArticles().contains(article);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ArticleWithinPersonPredicate)) {
            return false;
        }

        ArticleWithinPersonPredicate otherArticleWithinPersonPredicate = (ArticleWithinPersonPredicate) other;
        return person.equals(otherArticleWithinPersonPredicate.person);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("person", person).toString();
    }
}
