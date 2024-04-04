package seedu.address.model.article;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.ParserUtil.parseDateToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * Represents an article in the address book.
 */
public class Article {
    private final Title title;
    private final Set<Outlet> outlets = new HashSet<>();
    private final Set<Author> authors = new HashSet<>();
    private final Set<Source> sources = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();
    private final PublicationDate publicationDate;

    private List<Person> persons = new ArrayList<>();

    /**
     * Enumeration of Status of an article.
     */
    public enum Status {
        DRAFT, PUBLISHED, ARCHIVED
    }

    private final Status status;
    private final Link link;

    /**
     * Constructs an Article object.
     *
     * @param title the title of the article.
     * @param authors the authors of the article.
     * @param publicationDate the date of publication.
     * @param sources the people interviewed.
     * @param tags the subject of the article.
     * @param status the current status of the article.
     */
    public Article(Title title, Set<Author> authors, Set<Source> sources, Set<Tag> tags,
                   Set<Outlet> outlets, PublicationDate publicationDate, Status status, Link link) {
        requireAllNonNull(title, authors, sources, tags, outlets, publicationDate, status);
        this.title = title;
        this.authors.addAll(authors);
        this.sources.addAll(sources);
        this.tags.addAll(tags);
        this.outlets.addAll(outlets);
        this.publicationDate = publicationDate;
        this.status = status;
        this.link = link;
    }

    public Title getTitle() {
        return title;
    }

    public Set<Author> getAuthors() {
        return Collections.unmodifiableSet(authors);
    }

    public PublicationDate getPublicationDate() {
        return this.publicationDate;
    }

    public String getPublicationDateAsString() {
        return parseDateToString(this.publicationDate.date);
    }

    public Set<Outlet> getOutlets() {
        return Collections.unmodifiableSet(outlets);
    }

    public Set<Source> getSources() {
        return Collections.unmodifiableSet(sources);
    }

    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public Status getStatus() {
        return this.status;
    }

    public List<Person> getPersons() {
        return persons;
    }
    public Link getLink() {
        return this.link;
    }

    /**
     * Returns true if all the attributes of Article class are identical to the attributes of an existing Article.
     *
     * @param otherArticle
     * @return
     */
    public boolean isSameArticle(Article otherArticle) {
        if (otherArticle == this) {
            return true;

        /*
         * If it is not draft and has same title as another article,
         * consider it as same article
        */
        } else if (otherArticle.getStatus() != Status.DRAFT && this.getStatus() != Status.DRAFT
                && otherArticle.getTitle().equals(this.title)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the persons list of a edited article.
     *
     * @param persons
     */
    public void setPersons(List<Person> persons) {
        makeLinks(persons);
        this.persons = persons;
    }

    /**
     * Makes links between the article and the persons in the list.
     *
     * @param persons
     */
    public void makeLinks(List<Person> persons) {
        for (Person person : persons) {
            makeLink(person);
        }
    }

    /**
     * Makes links between the article and the person.
     *
     * @param person
     */
    public void makeLink(Person person) {
        for (Author author : authors) {
            if (author.authorName.equals(person.getNameString())) {
                persons.add(person);
                person.addArticle(this);
            }
        }
        for (Source source : sources) {
            if (source.sourceName.equals(person.getNameString())) {
                persons.add(person);
                person.addArticle(this);
            }
        }
    }

    /**
     * Updates the names in the article when a person is edited.
     *
     * @param from
     * @param to
     */
    public void updateNamesInArticle(Person from, Person to) {
        for (Author author : authors) {
            if (author.authorName.equals(from.getNameString())) {
                authors.remove(author);
                persons.remove(from);
                authors.add(new Author(to.getNameString()));
                persons.add(to);
            }
        }
        for (Source source : sources) {
            if (source.sourceName.equals(from.getNameString())) {
                sources.remove(source);
                persons.remove(from);
                sources.add(new Source(to.getNameString()));
                persons.add(to);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Article)) {
            return false;
        }

        Article otherArticle = (Article) other;
        return title.equals(otherArticle.title)
                && authors.equals(otherArticle.authors)
                && sources.equals(otherArticle.sources)
                && publicationDate.equals(otherArticle.publicationDate)
                && tags.equals(otherArticle.tags)
                && status.equals(otherArticle.status)
                && link.equals(otherArticle.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, publicationDate, sources, tags, status, link);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("title", title)
                .add("authors", authors)
                .add("publicationDate", publicationDate)
                .add("sources", sources)
                .add("tags", tags)
                .add("status", status)
                .add("link", link)
                .toString();
    }
}
