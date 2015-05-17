package com.veight.cms.api.model;

import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Represents category of article
 *
 * @author Oleg Filippov
 */
@Data
@XmlRootElement
public class CategoryModel implements Serializable {

    @XmlElement(name = "id")
    private String id;
    /**
     * Category name
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * Article count having this category
     */
    @XmlElement(name = "articleCount")
    private int articleCount;

    /**
     * Articles having this category
     */
    @XmlElement(name = "articles")
    private Set<ArticleModel> articles;

    /**
     * Default constructor
     */
    public CategoryModel() {
    }
}
