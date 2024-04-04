package seedu.address.model.article;

import java.util.function.Predicate;

import seedu.address.model.article.exceptions.InvalidDatesException;

/**
 * Ensures that an {@code Article}'s {@code PublicationDate} falls within desired period.
 */
public class ArticleMatchesTimePeriodPredicate implements Predicate<Article> {
    private PublicationDate start;
    private PublicationDate end;

    /**
     * Constructs a predicate that tests if article was published in desired time period.
     * @param start The earliest date the article could have been published.
     * @param end The latest date the article could have been published.
     */
    public ArticleMatchesTimePeriodPredicate(PublicationDate start, PublicationDate end) throws InvalidDatesException {
        this.start = start;
        this.end = end;
        if (end.date.isBefore(start.date)) {
            throw new InvalidDatesException();
        }
    }

    @Override
    public boolean test(Article article) {
        PublicationDate articleDate = article.getPublicationDate();
        return articleDate.date.isAfter(start.date) && articleDate.date.isBefore(end.date);
    }
}
