package com.veight.cms.entities;

import com.veight.common.entities.UUIDEntity;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents an article with String content
 *
 * @author Oleg Filippov
 */
@Entity
@Table(name = "TB_ARTICLE")
@NamedQueries({
    @NamedQuery(
            name = "ArticleModel.GET_ALL_BY_CATEGORY_NAME",
            query = "FROM ArticleModel article WHERE article.category.name = :name ORDER BY article.created DESC"),
    @NamedQuery(
            name = "ArticleModel.COUNT_ALL_BY_CATEGORY_NAME",
            query = "SELECT count(article) FROM ArticleModel article WHERE article.category.name = :name ORDER BY article.created DESC"),
    @NamedQuery(
            name = "ArticleModel.GET_ARTICLE_COUNT_BY_CATEGORY_ID",
            query = "SELECT count(article) FROM ArticleModel article WHERE article.category = :category")
})
public class ArticleModel extends UUIDEntity {

    private static final long serialVersionUID = 38150497082508411L;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "preview", nullable = false)
    private String preview;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * Article creation date and time
     */
    @Column(name = "created", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private final Date created;

    /**
     * Article modification date and time
     */
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    /**
     * Article view count
     */
    @Column(name = "view_count", insertable = false, columnDefinition = "INT DEFAULT 0")
    private int viewCount;

    /**
     * Category of this article
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    /**
     * Comments to this article
     */
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("created desc")
    private Set<CommentModel> comments;

    /**
     * Tags of this article
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "TB_ARTICLE_TAG",
            joinColumns = {
                @JoinColumn(name = "article_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id")})
    @OrderBy("name")
    private Set<TagModel> tags;

    /**
     * Default constructor initializing needed fields
     */
    public ArticleModel() {
        created = new Date();
        viewCount = 0;
    }

    /**
     * @return article title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title article title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return article preview
     */
    public String getPreview() {
        return preview;
    }

    /**
     * @param preview article preview to set
     */
    public void setPreview(String preview) {
        this.preview = preview;
    }

    /**
     * @return article content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content article content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return article date and time of creation
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @return article modification date and time
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified date and time when article was last modified
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * @return article view count
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount article view count to set
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return category of this article
     */
    public CategoryModel getCategory() {
        return category;
    }

    /**
     * @param category category of this article to set
     */
    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    /**
     * @return comments to this article
     */
    public Set<CommentModel> getComments() {
        return comments;
    }

    /**
     * @param comments comments to this article to set
     */
    public void setComments(Set<CommentModel> comments) {
        this.comments = comments;
    }

    /**
     * @return tags of this article
     */
    public Set<TagModel> getTags() {
        return tags;
    }

    /**
     * @param tags tags of this article to set
     */
    public void setTags(Set<TagModel> tags) {
        this.tags = tags;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result
                + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result
                + ((getCreated() == null) ? 0 : getCreated().hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        ArticleModel other = (ArticleModel) obj;

        if (getTitle() != null
                ? !getTitle().equals(other.getTitle())
                : other.getTitle() != null) {
            return false;
        }
        if (getCreated() != null
                ? getCreated().compareTo(other.getCreated()) != 0
                : other.getCreated() != null) {
            return false;
        }
        return true;
    }
}
