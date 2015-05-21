package com.veight.cms.entities;

import com.veight.common.entities.UUIDEntity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents category of article
 *
 * @author Oleg Filippov
 */
@Entity
@Table(name = "TB_CATEGORY")
@NamedQueries({
    @NamedQuery(
            name = "CategoryModel.GET_ALL",
            query = "FROM CategoryModel c ORDER BY c.name"),
    @NamedQuery(
            name = "CategoryModel.GET_BY_NAME",
            query = "FROM CategoryModel c WHERE c.name = :name")
})
public class CategoryModel extends UUIDEntity {

    private static final long serialVersionUID = 7369591777044660460L;

    /**
     * Category name
     */
    @Column(name = "name", nullable = false, unique = true, length = 30)
    private String name;

    /**
     * Articles having this category
     */
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<ArticleModel> articles;

    /**
     * Default constructor
     */
    public CategoryModel() {
    }

    /**
     * @return name of this category
     */
    public String getName() {
        return name;
    }

    /**
     * @param name category name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return articles having this category
     */
    public Set<ArticleModel> getArticles() {
        return articles;
    }

    /**
     * @param articles articles having this category
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
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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

        CategoryModel other = (CategoryModel) obj;

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
        return String.format("Category[id=%d, name=%s]", getId(), getName());
    }
}
