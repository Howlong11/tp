package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.articlecommands.EditArticleCommand.EditArticleDescriptor;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.article.Article;
import seedu.address.model.article.Author;
import seedu.address.model.article.Link;
import seedu.address.model.article.Outlet;
import seedu.address.model.article.Source;
import seedu.address.model.article.Title;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditArticleDescriptor objects.
 */
public class EditArticleDescriptorBuilder {

    private EditArticleDescriptor descriptor;

    public EditArticleDescriptorBuilder() {
        descriptor = new EditArticleDescriptor();
    }

    public EditArticleDescriptorBuilder(EditArticleDescriptor descriptor) {
        this.descriptor = new EditArticleDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditArticleDescriptor} with fields containing {@code article}'s details
     */
    public EditArticleDescriptorBuilder(Article article) {
        descriptor = new EditArticleDescriptor();
        descriptor.setTitle(article.getTitle());
        descriptor.setAuthors(article.getAuthors());
        descriptor.setPublicationDate(article.getPublicationDate());
        descriptor.setSources(article.getSources());
        descriptor.setOutlets(article.getOutlets());
        descriptor.setTags(article.getTags());
        descriptor.setStatus(article.getStatus());
        descriptor.setLink(article.getLink());
    }

    /**
     * Sets the {@code Title} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withTitle(String title) {
        descriptor.setTitle(new Title(title));
        return this;
    }

    /**
     * Sets the {@code Authors} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withAuthors(String... authors) {
        Set<Author> authorSet = Stream.of(authors).map(Author::new).collect(Collectors.toSet());
        descriptor.setAuthors(authorSet);
        return this;
    }

    /**
     * Sets the {@code PublicationDate} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withPublicationDate(String publicationDate) {
        try {
            descriptor.setPublicationDate(ParserUtil.parsePublicationDate(publicationDate));
        } catch (ParseException pe) {
            assert false : "This should not happen.";
        }
        return this;
    }

    /**
     * Sets the {@code Sources} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withSources(String... sources) {
        Set<Source> sourceSet = Stream.of(sources).map(Source::new).collect(Collectors.toSet());
        descriptor.setSources(sourceSet);
        return this;
    }

    /**
     * Sets the {@code Outlets} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withOutlets(String... outlets) {
        Set<Outlet> outletSet = Stream.of(outlets).map(Outlet::new).collect(Collectors.toSet());
        descriptor.setOutlets(outletSet);
        return this;
    }

    /**
     * Parses the {@code articleTags} into a {@code Set<Tag>} and set it to the {@code EditArticleDescriptor}
     * that we are building.
     */
    public EditArticleDescriptorBuilder withTags(String... articleTags) {
        Set<Tag> articleTagSet = Stream.of(articleTags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(articleTagSet);
        return this;
    }

    /**
     * Sets the {@code Status} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withStatus(String status) {
        try {
            descriptor.setStatus(ParserUtil.parseStatus(status));
        } catch (ParseException pe) {
            assert false : "This should not happen.";
        }
        return this;
    }

    /**
     * Sets the {@code Link} of the {@code EditArticleDescriptor} that we are building.
     */
    public EditArticleDescriptorBuilder withLink(String link) {
        descriptor.setLink(new Link(link));
        return this;
    }

    public EditArticleDescriptor build() {
        return descriptor;
    }
}
