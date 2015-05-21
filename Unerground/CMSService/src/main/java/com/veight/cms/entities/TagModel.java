package com.veight.cms.entities;

import com.veight.common.entities.UUIDEntity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Represents tag of article
 *
 * @author Oleg Filippov
 */
@Entity
@Table(name = "TB_TAG")
public class TagModel extends UUIDEntity {

    private static final long serialVersionUID = 984410247121721301L;

    /**
     * Tag name
     */
    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    /**
     * Articles tagged with this tag
     */
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<ArticleModel> articles;

    /**
     * Default constructor
     */
    public TagModel() {
    }

    /**
     * @return tag name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name tag name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return articles tagged with this tag
     */
    public Set<ArticleModel> getArticles() {
        return articles;
    }

    /**
     * @param articles articles tagged with this tag
     */
    public void setArticles(Set<ArticleModel> articles) {
        this.articles = articles;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result
                + ((getName() == null) ? 0 : getName().hashCode());
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

        TagModel other = (TagModel) obj;

        if (getName() != null
                ? !getName().equals(other.getName())
                : other.getName() != null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Tag[id=%d, name=%s]", getId(), getName());
    }
}
