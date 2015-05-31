package com.veight.cms.model;

import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Represents tag of article
 *
 * @author Oleg Filippov
 */
@XmlRootElement
public class Tag implements Serializable {

    @XmlElement(name = "id")
    private String id;
    /**
     * Tag name
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * Article count tagged with this tag
     */
    @XmlElement(name = "articleCount")
    private int articleCount;

    /**
     * Articles tagged with this tag
     */
    @XmlElement(name = "articles")
    private Set<Article> articles;

    /**
     * Default constructor
     */
    public Tag() {
    }

    public Tag(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
     * @return article count tagged with this tag
     */
    public int getArticleCount() {
        return articleCount;
    }

    /**
     * @return scale of this tag
     */
    public int getScale() {
        // need to change
        return articleCount > 9 ? 9 : articleCount;
    }

    /**
     * @return articles tagged with this tag
     */
    public Set<Article> getArticles() {
        return articles;
    }

    /**
     * @param articles articles tagged with this tag
     */
    public void setArticles(Set<Article> articles) {
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

        Tag other = (Tag) obj;

        if (getName() != null
                ? !getName().equals(other.getName())
                : other.getName() != null) {
            return false;
        }
        return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Tag[id=%d, name=%s]",getId(), getName());
    }
}
