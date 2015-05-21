package com.veight.cms.entities;

import com.veight.common.entities.UUIDEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents comment on article
 *
 * @author Oleg Filippov
 */
@Entity
@Table(name = "TB_COMMENT")
public class CommentModel extends UUIDEntity {

    private static final long serialVersionUID = -4252140027137381170L;

    /**
     * Comment content
     */
    @Column(name = "content", length = 500)
    private String content;

    /**
     * Creation date and time
     */
    @Column(name = "created", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private final Date created;

    /**
     * Article which owns comment
     */
    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleModel article;

    /**
     * Default constructor. For Hibernate use only
     */
    protected CommentModel() {
        created = new Date();
    }

    /**
     * Constructor initializing required fields
     *
     * @param article
     * @param content
     */
    public CommentModel(ArticleModel article, String content) {
        created = new Date();
        this.article = article;
        this.content = content;
    }

    /**
     * @return comment content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content comment content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return comment creation date and time
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @return article which owns this comment
     */
    public ArticleModel getArticle() {
        return article;
    }

    /**
     * @param article article which owns this comment
     */
    public void setArticle(ArticleModel article) {
        this.article = article;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result
                + ((getContent() == null) ? 0 : getContent().hashCode());
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

        CommentModel other = (CommentModel) obj;

        if (getContent() != null
                ? !getContent().equals(other.getContent())
                : other.getContent() != null) {
            return false;
        }
        if (getCreated() != null
                ? getCreated().compareTo(other.getCreated()) != 0
                : other.getCreated() != null) {
            return false;
        }
        return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Comment[id=%d, article_id=%s]",
                getId(),
                getArticle() == null ? "null" : getArticle().getId());
    }
}
